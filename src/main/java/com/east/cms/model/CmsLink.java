package com.east.cms.model;

public class CmsLink {
    private Integer cmsLinkId;

    private String title;

    private String url;

    private String type;

    private String newWin;

    private String urlId;

    private String urlClass;

    private Integer pos;

    public Integer getCmsLinkId() {
        return cmsLinkId;
    }

    public void setCmsLinkId(Integer cmsLinkId) {
        this.cmsLinkId = cmsLinkId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNewWin() {
        return newWin;
    }

    public void setNewWin(String newWin) {
        this.newWin = newWin;
    }

    public String getUrlId() {
        return urlId;
    }

    public void setUrlId(String urlId) {
        this.urlId = urlId;
    }

    public String getUrlClass() {
        return urlClass;
    }

    public void setUrlClass(String urlClass) {
        this.urlClass = urlClass;
    }

    public Integer getPos() {
        return pos;
    }

    public void setPos(Integer pos) {
        this.pos = pos;
    }
}