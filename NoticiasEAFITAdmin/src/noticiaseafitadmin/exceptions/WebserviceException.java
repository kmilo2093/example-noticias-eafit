package noticiaseafitadmin.exceptions;

/**
 *
 * @author Rodrigo
 */
public class WebserviceException extends Exception {

    private String type;
    private String category;
    private String code;

    public WebserviceException(String type, String category, String code, String message) {
        super(message);
        this.type = type;
        this.category = category;
        this.code = code;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }
}
