/*
 * Copyright (c) 2021 Karina Ayabire-Ayabire <karina.ayabire@hotmail.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package cl.ucn.disc.dsm.kayabire.directorio;


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

