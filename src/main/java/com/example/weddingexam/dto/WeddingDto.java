package com.example.weddingexam.dto;

public class WeddingDto {

    private Long id;
    private String groomName, brideName;
    private String weddingDate, weddingTime, weddingPlace, weddingAddress;
    private String greetingTitle, greetingText, greetingAlign;
    private Boolean greetingVisible;

    // 혼주 정보
    private String groomFatherName, groomMotherName, groomFatherPhone, groomMotherPhone;
    private String brideFatherName, brideMotherName, brideFatherPhone, brideMotherPhone;
    private String groomPhone, bridePhone;
    private Boolean hostsVisible;

    // 고인 표시 (true=고인)
    private Boolean groomFatherDeceased, groomMotherDeceased;
    private Boolean brideFatherDeceased, brideMotherDeceased;

    // 고인 표시 방식: "hanja"(故 한자) or "flower"(국화꽃)
    private String deceasedDisplayType;

    // 관계 (장남/차남/장녀 등)
    private String groomRelation, brideRelation;

    // 신랑/신부 표시 순서 ("groom" = 신랑 먼저, "bride" = 신부 먼저)
    private String displayOrder;

    // 연락하기 팝업 사용 여부
    private Boolean contactPopupEnabled;

    // 달력/D-Day
    private Boolean calendarVisible, ddayVisible;
    private String calendarStyle;   // "basic" / "date" / "en" / "text"
    private String ddayStyle;       // "text" / "clock" / "clock_bottom" / "clock_inline"

    // 지도
    private String mapPlaceName, mapAddressRoad, mapAddress;
    private Double mapLat, mapLng;       // 카카오맵 좌표
    private String mapZoomLevel;         // 20M/30M/50M/100M/250M/500M
    private Boolean mapDetailView;
    private Boolean mapSketchUse;
    private Boolean mapVisible, mapDetailEnabled, mapLocked;
    private Boolean mapNaviKakao = false, mapNaviTmap = false, mapNaviNaver = false;

    // 갤러리
    private Boolean galleryVisible;
    private Boolean accountVisible;
    private String galleryImages;        // 쉼표 구분 URL or base64
    private String galleryType;          // "slide"/"grid3"/"grid_mixed"/"grid_mixed2"
    private Boolean galleryScrollGuide;

    // 사진
    private String photoFilter, mainPhotoBase64;
    private String mainDesign, mainFont, mainFontSize, mainFontColor, colorEffect, mainEffect, bgm;

    public WeddingDto() {}

    // ── Getters ──────────────────────────────────────
    public Long getId() { return id; }
    public String getGroomName() { return groomName; }
    public String getBrideName() { return brideName; }
    public String getWeddingDate() { return weddingDate; }
    public String getWeddingTime() { return weddingTime; }
    public String getWeddingPlace() { return weddingPlace; }
    public String getWeddingAddress() { return weddingAddress; }
    public String getGreetingTitle() { return greetingTitle; }
    public String getGreetingText() { return greetingText; }
    public String getGreetingAlign() { return greetingAlign; }
    public Boolean getGreetingVisible() { return greetingVisible; }
    public String getGroomFatherName() { return groomFatherName; }
    public String getGroomMotherName() { return groomMotherName; }
    public String getGroomFatherPhone() { return groomFatherPhone; }
    public String getGroomMotherPhone() { return groomMotherPhone; }
    public String getBrideFatherName() { return brideFatherName; }
    public String getBrideMotherName() { return brideMotherName; }
    public String getBrideFatherPhone() { return brideFatherPhone; }
    public String getBrideMotherPhone() { return brideMotherPhone; }
    public String getGroomPhone() { return groomPhone; }
    public String getBridePhone() { return bridePhone; }
    public Boolean getHostsVisible() { return hostsVisible; }
    public Boolean getGroomFatherDeceased() { return groomFatherDeceased; }
    public Boolean getGroomMotherDeceased() { return groomMotherDeceased; }
    public Boolean getBrideFatherDeceased() { return brideFatherDeceased; }
    public Boolean getBrideMotherDeceased() { return brideMotherDeceased; }
    public String getDeceasedDisplayType() { return deceasedDisplayType; }
    public String getGroomRelation() { return groomRelation; }
    public String getBrideRelation() { return brideRelation; }
    public String getDisplayOrder() { return displayOrder; }
    public Boolean getContactPopupEnabled() { return contactPopupEnabled; }
    public Boolean getCalendarVisible() { return calendarVisible; }
    public Boolean getDdayVisible() { return ddayVisible; }
    public String getCalendarStyle() { return calendarStyle; }
    public String getDdayStyle() { return ddayStyle; }
    public String getMapPlaceName() { return mapPlaceName; }
    public String getMapAddressRoad() { return mapAddressRoad; }
    public String getMapAddress() { return mapAddress; }
    public Double getMapLat() { return mapLat; }
    public Double getMapLng() { return mapLng; }
    public String getMapZoomLevel() { return mapZoomLevel; }
    public Boolean getMapDetailView() { return mapDetailView; }
    public Boolean getMapSketchUse() { return mapSketchUse; }
    public Boolean getMapVisible() { return mapVisible; }
    public Boolean getMapLocked() { return mapLocked; }
    public Boolean getMapDetailEnabled() { return mapDetailEnabled; }
    public Boolean getMapNaviKakao() { return mapNaviKakao; }
    public Boolean getMapNaviTmap() { return mapNaviTmap; }
    public Boolean getMapNaviNaver() { return mapNaviNaver; }
    public Boolean getGalleryVisible() { return galleryVisible; }
    public Boolean getAccountVisible() { return accountVisible; }
    public String getGalleryImages() { return galleryImages; }
    public String getGalleryType() { return galleryType; }
    public Boolean getGalleryScrollGuide() { return galleryScrollGuide; }
    public String getPhotoFilter() { return photoFilter; }
    public String getMainPhotoBase64() { return mainPhotoBase64; }

    // ── Setters ──────────────────────────────────────
    public void setId(Long v) { this.id = v; }
    public void setGroomName(String v) { this.groomName = v; }
    public void setBrideName(String v) { this.brideName = v; }
    public void setWeddingDate(String v) { this.weddingDate = v; }
    public void setWeddingTime(String v) { this.weddingTime = v; }
    public void setWeddingPlace(String v) { this.weddingPlace = v; }
    public void setWeddingAddress(String v) { this.weddingAddress = v; }
    public void setGreetingTitle(String v) { this.greetingTitle = v; }
    public void setGreetingText(String v) { this.greetingText = v; }
    public void setGreetingAlign(String v) { this.greetingAlign = v; }
    public void setGreetingVisible(Boolean v) { this.greetingVisible = v; }
    public void setGroomFatherName(String v) { this.groomFatherName = v; }
    public void setGroomMotherName(String v) { this.groomMotherName = v; }
    public void setGroomFatherPhone(String v) { this.groomFatherPhone = v; }
    public void setGroomMotherPhone(String v) { this.groomMotherPhone = v; }
    public void setBrideFatherName(String v) { this.brideFatherName = v; }
    public void setBrideMotherName(String v) { this.brideMotherName = v; }
    public void setBrideFatherPhone(String v) { this.brideFatherPhone = v; }
    public void setBrideMotherPhone(String v) { this.brideMotherPhone = v; }
    public void setGroomPhone(String v) { this.groomPhone = v; }
    public void setBridePhone(String v) { this.bridePhone = v; }
    public void setHostsVisible(Boolean v) { this.hostsVisible = v; }
    public void setGroomFatherDeceased(Boolean v) { this.groomFatherDeceased = v; }
    public void setGroomMotherDeceased(Boolean v) { this.groomMotherDeceased = v; }
    public void setBrideFatherDeceased(Boolean v) { this.brideFatherDeceased = v; }
    public void setBrideMotherDeceased(Boolean v) { this.brideMotherDeceased = v; }
    public void setDeceasedDisplayType(String v) { this.deceasedDisplayType = v; }
    public void setGroomRelation(String v) { this.groomRelation = v; }
    public void setBrideRelation(String v) { this.brideRelation = v; }
    public void setDisplayOrder(String v) { this.displayOrder = v; }
    public void setContactPopupEnabled(Boolean v) { this.contactPopupEnabled = v; }
    public void setCalendarVisible(Boolean v) { this.calendarVisible = v; }
    public void setDdayVisible(Boolean v) { this.ddayVisible = v; }
    public void setCalendarStyle(String v) { this.calendarStyle = v; }
    public void setDdayStyle(String v) { this.ddayStyle = v; }
    public void setMapPlaceName(String v) { this.mapPlaceName = v; }
    public void setMapAddressRoad(String v) { this.mapAddressRoad = v; }
    public void setMapAddress(String v) { this.mapAddress = v; }
    public void setMapLat(Double v) { this.mapLat = v; }
    public void setMapLng(Double v) { this.mapLng = v; }
    public void setMapZoomLevel(String v) { this.mapZoomLevel = v; }
    public void setMapDetailView(Boolean v) { this.mapDetailView = v; }
    public void setMapSketchUse(Boolean v) { this.mapSketchUse = v; }
    public void setMapVisible(Boolean v) { this.mapVisible = v; }
    public void setMapLocked(Boolean v) { this.mapLocked = v; }
    public void setMapDetailEnabled(Boolean v) { this.mapDetailEnabled = v; }
    public void setMapNaviKakao(Boolean v) { this.mapNaviKakao = v; }
    public void setMapNaviTmap(Boolean v) { this.mapNaviTmap = v; }
    public void setMapNaviNaver(Boolean v) { this.mapNaviNaver = v; }
    public void setGalleryVisible(Boolean v) { this.galleryVisible = v; }
    public void setAccountVisible(Boolean v) { this.accountVisible = v; }
    public void setGalleryImages(String v) { this.galleryImages = v; }
    public void setGalleryType(String v) { this.galleryType = v; }
    public void setGalleryScrollGuide(Boolean v) { this.galleryScrollGuide = v; }
    public void setPhotoFilter(String v) { this.photoFilter = v; }

    public String getMainDesign() { return mainDesign; }
    public void setMainDesign(String v) { this.mainDesign = v; }
    public String getMainFont() { return mainFont; }
    public void setMainFont(String v) { this.mainFont = v; }
    public String getMainFontSize() { return mainFontSize; }
    public void setMainFontSize(String v) { this.mainFontSize = v; }
    public String getMainFontColor() { return mainFontColor; }
    public void setMainFontColor(String v) { this.mainFontColor = v; }
    public String getColorEffect() { return colorEffect; }
    public void setColorEffect(String v) { this.colorEffect = v; }
    public String getMainEffect() { return mainEffect; }
    public void setMainEffect(String v) { this.mainEffect = v; }
    public String getBgm() { return bgm; }
    public void setBgm(String v) { this.bgm = v; }
    public void setMainPhotoBase64(String v) { this.mainPhotoBase64 = v; }

    // ── Builder ──────────────────────────────────────
    public static Builder builder() { return new Builder(); }
    public static class Builder {
        private final WeddingDto d = new WeddingDto();
        public Builder id(Long v) { d.id=v; return this; }
        public Builder groomName(String v) { d.groomName=v; return this; }
        public Builder brideName(String v) { d.brideName=v; return this; }
        public Builder weddingDate(String v) { d.weddingDate=v; return this; }
        public Builder weddingTime(String v) { d.weddingTime=v; return this; }
        public Builder weddingPlace(String v) { d.weddingPlace=v; return this; }
        public Builder weddingAddress(String v) { d.weddingAddress=v; return this; }
        public Builder greetingTitle(String v) { d.greetingTitle=v; return this; }
        public Builder greetingText(String v) { d.greetingText=v; return this; }
        public Builder greetingAlign(String v) { d.greetingAlign=v; return this; }
        public Builder greetingVisible(Boolean v) { d.greetingVisible=v; return this; }
        public Builder groomFatherName(String v) { d.groomFatherName=v; return this; }
        public Builder groomMotherName(String v) { d.groomMotherName=v; return this; }
        public Builder groomFatherPhone(String v) { d.groomFatherPhone=v; return this; }
        public Builder groomMotherPhone(String v) { d.groomMotherPhone=v; return this; }
        public Builder brideFatherName(String v) { d.brideFatherName=v; return this; }
        public Builder brideMotherName(String v) { d.brideMotherName=v; return this; }
        public Builder brideFatherPhone(String v) { d.brideFatherPhone=v; return this; }
        public Builder brideMotherPhone(String v) { d.brideMotherPhone=v; return this; }
        public Builder groomPhone(String v) { d.groomPhone=v; return this; }
        public Builder bridePhone(String v) { d.bridePhone=v; return this; }
        public Builder hostsVisible(Boolean v) { d.hostsVisible=v; return this; }
        public Builder groomFatherDeceased(Boolean v) { d.groomFatherDeceased=v; return this; }
        public Builder groomMotherDeceased(Boolean v) { d.groomMotherDeceased=v; return this; }
        public Builder brideFatherDeceased(Boolean v) { d.brideFatherDeceased=v; return this; }
        public Builder brideMotherDeceased(Boolean v) { d.brideMotherDeceased=v; return this; }
        public Builder deceasedDisplayType(String v) { d.deceasedDisplayType=v; return this; }
        public Builder groomRelation(String v) { d.groomRelation=v; return this; }
        public Builder brideRelation(String v) { d.brideRelation=v; return this; }
        public Builder displayOrder(String v) { d.displayOrder=v; return this; }
        public Builder contactPopupEnabled(Boolean v) { d.contactPopupEnabled=v; return this; }
        public Builder calendarVisible(Boolean v) { d.calendarVisible=v; return this; }
        public Builder ddayVisible(Boolean v) { d.ddayVisible=v; return this; }
        public Builder calendarStyle(String v) { d.calendarStyle=v; return this; }
        public Builder ddayStyle(String v) { d.ddayStyle=v; return this; }
        public Builder mapPlaceName(String v) { d.mapPlaceName=v; return this; }
        public Builder mapAddressRoad(String v) { d.mapAddressRoad=v; return this; }
        public Builder mapAddress(String v) { d.mapAddress=v; return this; }
        public Builder mapLat(Double v) { d.mapLat=v; return this; }
        public Builder mapLng(Double v) { d.mapLng=v; return this; }
        public Builder mapZoomLevel(String v) { d.mapZoomLevel=v; return this; }
        public Builder mapDetailView(Boolean v) { d.mapDetailView=v; return this; }
        public Builder mapSketchUse(Boolean v) { d.mapSketchUse=v; return this; }
        public Builder mapVisible(Boolean v) { d.mapVisible=v; return this; }
        public Builder mapLocked(Boolean v) { d.mapLocked=v; return this; }
        public Builder mapDetailEnabled(Boolean v) { d.mapDetailEnabled=v; return this; }
        public Builder mapNaviKakao(Boolean v) { d.mapNaviKakao=v; return this; }
        public Builder mapNaviTmap(Boolean v) { d.mapNaviTmap=v; return this; }
        public Builder mapNaviNaver(Boolean v) { d.mapNaviNaver=v; return this; }
        public Builder galleryVisible(Boolean v) { d.galleryVisible=v; return this; }
        public Builder accountVisible(Boolean v) { d.accountVisible=v; return this; }
        public Builder galleryImages(String v) { d.galleryImages=v; return this; }
        public Builder galleryType(String v) { d.galleryType=v; return this; }
        public Builder galleryScrollGuide(Boolean v) { d.galleryScrollGuide=v; return this; }
        public Builder photoFilter(String v) { d.photoFilter=v; return this; }
        public Builder mainDesign(String v) { d.mainDesign=v; return this; }
        public Builder mainFont(String v) { d.mainFont=v; return this; }
        public Builder mainFontSize(String v) { d.mainFontSize=v; return this; }
        public Builder mainFontColor(String v) { d.mainFontColor=v; return this; }
        public Builder colorEffect(String v) { d.colorEffect=v; return this; }
        public Builder mainEffect(String v) { d.mainEffect=v; return this; }
        public Builder bgm(String v) { d.bgm=v; return this; }
        public Builder mainPhotoBase64(String v) { d.mainPhotoBase64=v; return this; }
        public WeddingDto build() { return d; }
    }
}
