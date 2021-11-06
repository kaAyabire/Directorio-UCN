package cl.ucn.disc.dsm.kayabire.scrapper;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * Main class to scrappe the Directorio Telefonico of UCN
 * @author Karina Ayabire Ayabire
 */
@Slf4j
public final class TheMain {

  private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

  /**
   * The starting point.
   * @param args to use.
   */
  public static void main(String[] args) throws IOException, InterruptedException {

    log.debug("Loading the Funcionarios from funcionarios.json ..");

    // Load the file into the data
    String data = FileUtils.readFileToString(new File("funcionarios.json"), StandardCharsets.UTF_8);

    //Define the type
    Type type=new TypeToken<List<Funcionario>>(){
    }.getType();


    //The list of Funcionario (string -> List<Funcionario>
    List<Funcionario> funcionarios = GSON.fromJson(data,type);

    // The latest id loaded
    int start = funcionarios.get(funcionarios.size() - 1).getId();
    int end = 30000;

    Random r = new Random();
    log.debug("Starting the Scrapping from {} to {} ..",start,end);

    for(int id = start ; id <= end ; id++){

      Thread.sleep(50 + r.nextInt(350));

      log.debug("Retriving Funcionario id: {}.",id);

      // Connect and get the Document
      Document doc= Jsoup.
          connect("https://admision01.ucn.cl/directoriotelefonicoemail/fichaGenerica/?cod=" + id).
          get();

      String nombre = doc.getElementById("lblNombre").text();
      String cargo = doc.getElementById("lblCargo").text();
      String unidad = doc.getElementById("lblUnidad").text();
      String email = doc.getElementById("lblEmail").text();
      String telefono = doc.getElementById("lblTelefono").text();
      String oficina = doc.getElementById("lblOficina").text();
      String direccion = doc.getElementById("lblDireccion").text();

      // Skip if data no found
      if(nombre.length() <=1){
        log.warn("No data found id: {}.",id);
        continue;
      }

      log.info("Funcionario id: {} founded: {}.",id,nombre);

      //Call the constructor
      Funcionario funcionario= Funcionario.builder()
          .id(id)
          .nombre(nombre)
          .cargo(cargo)
          .unidad(unidad)
          .email(email)
          .telefono(telefono)
          .oficina(oficina)
          .direccion(direccion)
          .build();

      funcionarios.add(funcionario);

      // Save by 25
      if(funcionarios.size() % 25 == 0){

        log.debug("Writing {} funcionarios to file ..",funcionarios.size());

        FileUtils.writeStringToFile(
            new File("funcionarios.json"),
            GSON.toJson(funcionarios),
            StandardCharsets.UTF_8);
      }

    }

    log.debug("Done");
  }

}
