package sit707_week2;

/**
 * Hello world!
 * @author Gayani Abewickrama
 */
public class Main 
{
    public static void main( String[] args )
    {
        SeleniumOperations.officeworks_registration_page("https://www.officeworks.com.au/app/identity/create-account");
        SeleniumOperations.alternative_registration_page("https://www.bunnings.com.au/register");;
        
    }
}
