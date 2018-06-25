package com.asuscomm.reisin.linker.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Link")
public class Link {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int linkId;
    private String linkName;
    private String groupId;
    private String linkUrl;
    private int linkPort;
    private String linkDescription;

    public int getLinkId() {
        return linkId;
    }

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public int getLinkPort() {
        return linkPort;
    }

    public void setLinkPort(int linkPort) {
        this.linkPort = linkPort;
    }

    public String getLinkDescription() {
        return linkDescription;
    }

    public void setLinkDescription(String linkDescription) {
        this.linkDescription = linkDescription;
    }

    @Override
    public String toString() {
        return "Link{" +
                "linkId=" + linkId +
                ", linkName='" + linkName + '\'' +
                ", groupId='" + groupId + '\'' +
                ", linkUrl='" + linkUrl + '\'' +
                ", linkPort=" + linkPort +
                ", linkDescription='" + linkDescription + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Link link = (Link) o;

        if (linkId != link.linkId) return false;
        if (linkPort != link.linkPort) return false;
        if (linkName != null ? !linkName.equals(link.linkName) : link.linkName != null) return false;
        if (groupId != null ? !groupId.equals(link.groupId) : link.groupId != null) return false;
        if (linkUrl != null ? !linkUrl.equals(link.linkUrl) : link.linkUrl != null) return false;
        return linkDescription != null ? linkDescription.equals(link.linkDescription) : link.linkDescription == null;
    }

    @Override
    public int hashCode() {
        int result = linkId;
        result = 31 * result + (linkName != null ? linkName.hashCode() : 0);
        result = 31 * result + (groupId != null ? groupId.hashCode() : 0);
        result = 31 * result + (linkUrl != null ? linkUrl.hashCode() : 0);
        result = 31 * result + linkPort;
        result = 31 * result + (linkDescription != null ? linkDescription.hashCode() : 0);
        return result;
    }
}
