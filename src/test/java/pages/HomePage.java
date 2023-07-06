package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    By findPlaylist= By.xpath("//section[@id='playlists']//li[5]");
    By playlistNameField= By.cssSelector("input[name='name']");
    String playlistName = "Edited Playlist Name";

    public void doubleClickPlaylist(){
        doubleClick(findPlaylist);
    }
    public void enterNewPlaylistName(String playlistName){
        findElement(playlistNameField).sendKeys(playlistName);
        findElement(playlistNameField).sendKeys((Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE)));
        findElement(playlistNameField).sendKeys(playlistName);
        findElement(playlistNameField).sendKeys((Keys.ENTER));
    }
    public boolean doesPlaylistExist(String playlistName){
        By newPlaylist=By.xpath("//a[contains(text(),'\"+newPlaylistName+\"')]");
        return findElement(newPlaylist).isDisplayed();
    }
}
