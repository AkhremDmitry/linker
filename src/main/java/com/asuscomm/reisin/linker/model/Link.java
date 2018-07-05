package com.asuscomm.reisin.linker.model;

import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;

@Entity(name = "links")
public class Link {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false, unique = true)
    private int id;
    @Column(name = "name", nullable = false, unique = true)
    private String name;
    //TODO set foreign key to groupID
    @Column(name = "groupId", nullable = false)
    private int groupId;
    @Column(name = "url")
    private String url;
    @Column(name = "port")
    private int port;
    @Column(name = "description")
    private String description;

    private boolean activity = false;

    public boolean isActivity() {
        return activity;
    }

    public void setActivity(boolean activity) {
        this.activity = activity;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    @Column(name = "logo")
    private String logo;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Link link = (Link) o;

        if (id != link.id) return false;
        if (groupId != link.groupId) return false;
        if (port != link.port) return false;
        if (name != null ? !name.equals(link.name) : link.name != null) return false;
        if (url != null ? !url.equals(link.url) : link.url != null) return false;
        if (description != null ? !description.equals(link.description) : link.description != null) return false;
        return logo != null ? logo.equals(link.logo) : link.logo == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + groupId;
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + port;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (logo != null ? logo.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Link{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", groupId=" + groupId +
                ", url='" + url + '\'' +
                ", port=" + port +
                ", description='" + description + '\'' +
                ", logo='" + logo + '\'' +
                '}';
    }
}
