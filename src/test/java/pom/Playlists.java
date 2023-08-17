package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class Playlists extends BasePage {

    public Playlists(WebDriver givenDriver) {
        super(givenDriver);
    }

    private By findPlaylist = By.xpath("//section[@id='playlists']//li[5]");
    private By playlistNameField = By.cssSelector("input[name='name']");
    private By playlist = By.xpath("//section[@id='songResultsWrapper']//button[2]");

    public void doubleClickPlaylist() {
        doubleClick(findPlaylist);
    }

    public void enterNewPlaylistName(String playlistName) {
        findElement(playlistNameField).sendKeys(playlistName);
        findElement(playlistNameField).sendKeys((Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE)));
        findElement(playlistNameField).sendKeys(playlistName);
        findElement(playlistNameField).sendKeys((Keys.ENTER));
    }

    public boolean doesPlaylistExist(String playlistName) {
        By newPlaylist = By.xpath("//a[text()='" + playlistName + "']");
        return findElement(newPlaylist).isDisplayed();
    }
//    public void enterNewPlaylistName(){
//        WebElement playlist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='playlists']//li[5]")));
//        actions.doubleClick(playlist).perform();
//        WebElement playlistTextField = driver.findElement(By.cssSelector("input[name='name']"));
//        playlistTextField.sendKeys((Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE)));
//        //element is required so clear does not work. ctrl a (to select all) then backspace
//        playlistTextField.sendKeys(newPlaylistName);
//        playlistTextField.sendKeys(Keys.ENTER);
//    }

    //    public boolean validateRenamedPlaylist(){
//        WebElement renamedPlaylist = driver.findElement(By.xpath("//a[contains(text(),'"+newPlaylistName+"')]"));
//        return renamedPlaylist.isDisplayed();
//    }
    public void addSongToPlaylist() {
        findElement(playlist).click();
        // WebElement playList = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='songResultsWrapper']//li[7]")));
        //   driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[7]"));
        // playList.click();
        //Thread.sleep(2000);
    }

    public void addSongToPlaylist() {
        WebElement addTo = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='songResultsWrapper']//button[2]")));
        //   driver.findElement(By.xpath("//section[@id='songResultsWrapper']//button[2]"));

        addTo.click();
        //Thread.sleep(1000);
    }

    public void addedSongSuccess() {
        WebElement verification =
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='success show']")));
        //driver.findElement(By.xpath("//div[@class='success show']"));
        //Thread.sleep(2000);
        Assert.assertEquals(verification.getText(), "Added 1 song into \"homework17.\"");
    }
}

