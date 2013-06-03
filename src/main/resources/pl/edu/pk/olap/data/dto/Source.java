package pl.edu.pk.olap.data.dto;

/**
 * User: suowik
 * Date: 30.05.13
 * Time: 14:47
 */
public enum Source {
    EURO_RTV_AGD("euro"),KOMPUTRONIK("komputronik"),MEDIA_MARKT("media_markt"),SATURN("saturn"),VOBIS("vobis");
    private String name;
    Source(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

