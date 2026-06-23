package com.example.weddingexam.controller;

import com.example.weddingexam.account.AccountDto;
import com.example.weddingexam.account.AccountService;
import com.example.weddingexam.dto.WeddingDto;
import com.example.weddingexam.service.WeddingService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.Map;

@Controller
public class WeddingController {

    private final WeddingService weddingService;
    private final AccountService accountService;

    @Value("${kakao.map.appkey:502b99c57514360a34fdf5b9181ed284}")
    private String kakaoAppKey;

    @Value("${kakao.map.restkey:03a041000c72178b476cbb6e29431e81}")
    private String kakaoRestKey;

    /** 카카오 키워드 검색 프록시 (REST API 키 사용) */
    /* ── Static Map 이미지 프록시 (서버→카카오API→클라이언트) ── */
    @GetMapping("/api/map/staticmap")
    public ResponseEntity<byte[]> staticMap(
            @RequestParam double lat,
            @RequestParam double lng,
            @RequestParam(defaultValue = "480") int w,
            @RequestParam(defaultValue = "280") int h,
            @RequestParam(defaultValue = "3")   int level) {
        String key = (kakaoRestKey != null && !kakaoRestKey.isEmpty()) ? kakaoRestKey : kakaoAppKey;
        try {
            RestTemplate rt = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", "KakaoAK " + key);
            String url = String.format(
                "https://dapi.kakao.com/v2/maps/staticmap?center=%f,%f&level=%d&w=%d&h=%d&markers=marker_b_%f_%f",
                lng, lat, level, w, h, lng, lat);
            ResponseEntity<byte[]> resp = rt.exchange(url, HttpMethod.GET,
                    new HttpEntity<>(headers), byte[].class);
            HttpHeaders out = new HttpHeaders();
            out.setContentType(MediaType.IMAGE_PNG);
            out.setCacheControl("max-age=3600");
            return new ResponseEntity<>(resp.getBody(), out, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).build();
        }
    }

    @GetMapping("/api/map/search")
    @ResponseBody
    public ResponseEntity<String> searchPlace(@RequestParam String query) {
        String key = (kakaoRestKey != null && !kakaoRestKey.isEmpty()) ? kakaoRestKey : kakaoAppKey;
        try {
            RestTemplate rt = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", "KakaoAK " + key);
            String url = "https://dapi.kakao.com/v2/local/search/keyword.json?query="
                       + java.net.URLEncoder.encode(query, "UTF-8") + "&size=15";
            ResponseEntity<String> resp = rt.exchange(url, HttpMethod.GET,
                    new HttpEntity<>(headers), String.class);
            return ResponseEntity.ok()
                .header("Content-Type", "application/json; charset=UTF-8")
                .body(resp.getBody());
        } catch (Exception e) {
            return ResponseEntity.ok("{\"documents\":[],\"meta\":{\"total_count\":0},\"error\":\"" + e.getMessage() + "\"}");
        }
    }

    public WeddingController(WeddingService weddingService, AccountService accountService) {
        this.weddingService = weddingService;
        this.accountService = accountService;
    }

    @GetMapping("/")
    public String invitation(Model model) {
        WeddingDto dto = weddingService.findFirst();
        addFormattedFields(model, dto);
        model.addAttribute("accounts", accountService.findAll());
        model.addAttribute("kakaoAppKey", kakaoAppKey);
        return "invitation";
    }

    @GetMapping("/wedding/{id}")
    public String invitationById(@PathVariable Long id, Model model) {
        WeddingDto dto = weddingService.findById(id);
        addFormattedFields(model, dto);
        model.addAttribute("accounts", accountService.findAll());
        model.addAttribute("kakaoAppKey", kakaoAppKey);
        return "invitation";
    }

    @GetMapping("/admin/edit")
    public String editForm(Model model) {
        model.addAttribute("wedding", weddingService.findFirst());
        model.addAttribute("accounts", accountService.findAll());
        model.addAttribute("kakaoAppKey", kakaoAppKey);
        return "admin/edit";
    }

    /** 저장된 메인 사진 base64 반환 (편집 페이지 미리보기용) */
    @GetMapping("/api/admin/photo")
    @ResponseBody
    public ResponseEntity<byte[]> getMainPhoto() {
        try {
            WeddingDto dto = weddingService.findFirst();
            if (dto.getMainPhotoBase64() == null || dto.getMainPhotoBase64().isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            byte[] bytes = java.util.Base64.getDecoder().decode(dto.getMainPhotoBase64());
            return ResponseEntity.ok()
                .header("Content-Type","image/jpeg")
                .body(bytes);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/admin/edit")
    public String updateWedding(@ModelAttribute WeddingDto dto) {
        if (dto.getId() != null) weddingService.update(dto.getId(), dto);
        else weddingService.save(dto);
        /* 편집 페이지로 돌아오되 saved=true 파라미터 → JS가 새 창으로 청첩장 열기 */
        return "redirect:/admin/edit?saved=true";
    }

    /** AJAX 자동저장 — 실시간 미리보기용 */
    @PostMapping("/api/admin/autosave")
    @ResponseBody
    public ResponseEntity<java.util.Map<String,Object>> autoSave(@RequestBody WeddingDto dto) {
        try {
            // null 체크박스 → false 처리
            if (dto.getMapNaviKakao() == null) dto.setMapNaviKakao(false);
            if (dto.getMapNaviTmap()  == null) dto.setMapNaviTmap(false);
            if (dto.getMapNaviNaver() == null) dto.setMapNaviNaver(false);
            if (dto.getAccountVisible()  == null) dto.setAccountVisible(false);
            if (dto.getGalleryVisible()  == null) dto.setGalleryVisible(false);
            if (dto.getMapVisible()      == null) dto.setMapVisible(false);
            if (dto.getGreetingVisible() == null) dto.setGreetingVisible(false);
            if (dto.getHostsVisible()    == null) dto.setHostsVisible(false);
            if (dto.getCalendarVisible() == null) dto.setCalendarVisible(false);
            if (dto.getDdayVisible()     == null) dto.setDdayVisible(false);
            if (dto.getDisplayOrder()    == null) dto.setDisplayOrder("groom");
            if (dto.getContactPopupEnabled() == null) dto.setContactPopupEnabled(true);
            if (dto.getId() != null) weddingService.update(dto.getId(), dto);
            else weddingService.save(dto);
            return ResponseEntity.ok(java.util.Map.of("success", true));
        } catch (Exception e) {
            return ResponseEntity.ok(java.util.Map.of("success", false, "error", e.getMessage()));
        }
    }

    @GetMapping("/api/wedding/{id}")
    @ResponseBody
    public ResponseEntity<WeddingDto> getWedding(@PathVariable Long id) {
        return ResponseEntity.ok(weddingService.findById(id));
    }

    @PostMapping("/api/wedding")
    @ResponseBody
    public ResponseEntity<WeddingDto> createWedding(@RequestBody WeddingDto dto) {
        return ResponseEntity.ok(weddingService.save(dto));
    }

    @PutMapping("/api/wedding/{id}")
    @ResponseBody
    public ResponseEntity<WeddingDto> updateWeddingApi(@PathVariable Long id, @RequestBody WeddingDto dto) {
        return ResponseEntity.ok(weddingService.update(id, dto));
    }

    @DeleteMapping("/api/wedding/{id}")
    @ResponseBody
    public ResponseEntity<Void> deleteWedding(@PathVariable Long id) {
        weddingService.delete(id);
        return ResponseEntity.noContent().build();
    }

    private void addFormattedFields(Model model, WeddingDto dto) {
        model.addAttribute("wedding", dto);
        model.addAttribute("greetingTitleHtml",
                dto.getGreetingTitle() != null ? dto.getGreetingTitle().replace("\n", "<br>") : "");
        model.addAttribute("greetingTextHtml",
                dto.getGreetingText() != null ? dto.getGreetingText().replace("\n", "<br>") : "");
    }
}
