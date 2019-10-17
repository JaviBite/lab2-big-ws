package translator.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import translator.Application;
import translator.domain.TranslatedText;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TranslatorServiceTest {

  @Autowired
  TranslatorService translatorService;

  @Test
  public void translateTest() {
    TranslatedText translatedText = translatorService.translate("en", "es", "This is a test of translation service");
    assertEquals("Esto es una prueba de servicio de traducción", translatedText.getTranslation());
  }

  @Test
  public void translateTest_ES_EN() {
    TranslatedText translatedText = translatorService.translate("es", "en", "Esto es una prueba de servicio de traducción");
    assertEquals("This is a proof of service translation%C3%B3n", translatedText.getTranslation());
  }

  @Test
  public void translateTest_FR_JA() {
    TranslatedText translatedText = translatorService.translate("fr", "ja", "C'est une preuve de service de traduction");
    assertEquals("C%27est証明の翻訳サービス", translatedText.getTranslation());
  }
}
