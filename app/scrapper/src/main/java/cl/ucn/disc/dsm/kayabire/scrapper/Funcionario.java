package cl.ucn.disc.dsm.kayabire.scrapper;

import lombok.Builder;
import lombok.Getter;
/**
 * The UCN Funcionario
 * @author Karina Ayabire
 */
@Builder
public final class Funcionario {

  /**
   * The id
   */
  @Getter
  private final Integer id;

  /**
   * The Nombre.
   */
  @Getter
  private final String nombre;

  /**
   * The Cargo.
   */
  @Getter
  private final String cargo;
  /**
   * The Unidad.
   */
  @Getter
  private final String unidad;

  /**
   * The Email.
   */
  @Getter
  private final String email;

  /**
   * The Telefono.
   */
  @Getter
  private final String telefono;

  /**
   * The Oficina.
   */
  @Getter
  private final String oficina;

  /**
   * The direccion.
   */
  @Getter
  private final String direccion;

}


