public class Token {
    Token_Category tokenCategory;
    String value;

    public Token(Token_Category tokenCategory, String value) {
        this.tokenCategory = tokenCategory;
        this.value = value;
    }

    public Token_Category getTokenCategory() {
        return tokenCategory;
    }

    public void setTokenCategory(Token_Category tokenCategory) {
        this.tokenCategory = tokenCategory;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
