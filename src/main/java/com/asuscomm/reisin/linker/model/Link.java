package com.asuscomm.reisin.linker.model;

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
    private String groupId;
    @Column(name = "url")
    private String url;
    @Column(name = "port")
    private int port;
    @Column(name = "description")
    private String description;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
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
    public String toString() {
        return "Link{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", groupId='" + groupId + '\'' +
                ", url='" + url + '\'' +
                ", port=" + port +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Link link = (Link) o;

        if (id != link.id) return false;
        if (port != link.port) return false;
        if (name != null ? !name.equals(link.name) : link.name != null) return false;
        if (groupId != null ? !groupId.equals(link.groupId) : link.groupId != null) return false;
        if (url != null ? !url.equals(link.url) : link.url != null) return false;
        return description != null ? description.equals(link.description) : link.description == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (groupId != null ? groupId.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + port;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
