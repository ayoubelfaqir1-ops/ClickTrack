package ma.clicktrack.dto;

import ma.clicktrack.model.Lien;

public record LienResponseDto(
        Long id,
        String lien,
        String destinationUrl,
        Long publisherId,
        String publisherFullName,
        String offre,
        Long clicks
) {
    public static LienResponseDto from(Lien lien) {
        if (lien == null) {
            return null;
        }
        return new LienResponseDto(
                lien.getId(),
                lien.getLien(),
                lien.getDestinationUrl(),
                lien.getPublisherId(),
                lien.getPublisherFullName(),
                lien.getOffre(),
                lien.getClicks()
        );
    }
}

