package ma.clicktrack.dto;

import ma.clicktrack.model.Lien;

public record LienResponseDto(
        String lien,
        String destinationUrl,
        String publisherFullName,
        String offre,
        Long clicks
) {
    public static LienResponseDto from(Lien lien) {
        if (lien == null) {
            return null;
        }
        return new LienResponseDto(
                lien.getLien(),
                lien.getDestinationUrl(),
                lien.getPublisherFullName(),
                lien.getOffre(),
                lien.getClicks()
        );
    }
}

