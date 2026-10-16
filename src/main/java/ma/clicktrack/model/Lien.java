package ma.clicktrack.model;

public class Lien {
    private Long id;
    private String lien; // tracking link like /t/1
    private String destinationUrl;
    private String publisherFullName;
    private Long publisherId;
    private String offre;
    private Long clicks;

    public Lien() {}

    public Lien(Long id, String lien, String destinationUrl, String publisherFullName, Long publisherId, String offre, Long clicks) {
        this.id = id;
        this.lien = lien;
        this.destinationUrl = destinationUrl;
        this.publisherFullName = publisherFullName;
        this.publisherId = publisherId;
        this.offre = offre;
        this.clicks = clicks;
    }

    public String getLien() {
        return lien;
    }

    public void setLien(String lien) {
        this.lien = lien;
    }

    public String getDestinationUrl() {
        return destinationUrl;
    }

    public void setDestinationUrl(String destinationUrl) {
        this.destinationUrl = destinationUrl;
    }

    public String getPublisherFullName() {
        return publisherFullName;
    }

    public void setPublisherFullName(String publisherFullName) {
        this.publisherFullName = publisherFullName;
    }

    public Long getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Long publisherId) {
        this.publisherId = publisherId;
    }

    public String getOffre() {
        return offre;
    }

    public void setOffre(String offre) {
        this.offre = offre;
    }

    public Long getClicks() {
        return clicks;
    }

    public void setClicks(Long clicks) {
        this.clicks = clicks;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
