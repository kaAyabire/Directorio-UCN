package cl.ucn.disc.dsm.kayabire.directorio;

import android.app.Application;
import android.content.Context;
import org.acra.ACRA;
import org.acra.BuildConfig;
import org.acra.annotation.AcraCore;
import org.acra.config.CoreConfigurationBuilder;
import org.acra.config.DialogConfigurationBuilder;
import org.acra.config.MailSenderConfigurationBuilder;
import org.acra.data.StringFormat;

/**
 * Main App.
 * @author Karina Ayabire Ayabire
 */
@AcraCore(buildConfigClass = BuildConfig.class)
public class App extends Application {

  /**
   * Main App.
   * @param base context to use.
   */
  @Override
  protected void attachBaseContext(Context base) {
    super.attachBaseContext(base);

    CoreConfigurationBuilder builder = new CoreConfigurationBuilder(this);
    builder
        .withBuildConfigClass(BuildConfig.class)
        .withReportFormat(StringFormat.JSON)
        .withEnabled(true);

    //ACRA Dialog Configuration
    builder.getPluginConfigurationBuilder(DialogConfigurationBuilder.class)
        .withResText(R.string.acra_dialog_tittle)
        .withResCommentPrompt(R.string.acra_dialog_comment)
        .withEnabled(true);

    //ACRA Email Configuration
    builder.getPluginConfigurationBuilder(MailSenderConfigurationBuilder.class)
        .withMailTo("karina.ayabire@hotmail.com")
        .withReportFileName("crash.txt")
        .withSubject(getString(R.string.acra_dialog_tittle))
        .withBody(getString(R.string.acra_dialog_comment))
        .withEnabled(true);

    // The following line triggers the initialization of ACRA
    ACRA.init(this, builder);
  }
}
