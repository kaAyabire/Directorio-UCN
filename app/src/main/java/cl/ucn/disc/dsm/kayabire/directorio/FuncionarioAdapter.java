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

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

/**
 * The Adapter of Funcionario.
 *
 * @author Karina Ayabire Ayabire
 */
public final class FuncionarioAdapter extends BaseAdapter {

  /**
   * The List of Funcionarios.
   */
  private final List<Funcionario> funcionarios = new ArrayList<>();

  /**
   * The Inflater
   */
  private LayoutInflater theInflater;

  /**
   * Constructor of the FuncionarioAdapter.
   *
   * @param context
   */
  public FuncionarioAdapter(Context context) {

    // Get the inflater
    this.theInflater = LayoutInflater.from(context);
  }

  /**
   * @return the size of the list of {@link Funcionario}.
   */
  @Override
  public int getCount() {
    return this.funcionarios.size();
  }

  /**
   * Return the {@link Funcionario} at the position position in the list.
   *
   * @param position
   * @return the {@link Funcionario}.
   */
  @Override
  public Funcionario getItem(int position) {
    return this.funcionarios.get(position);
  }

  /**
   * @param position to get.
   * @return the same position.
   */
  @Override
  public long getItemId(int position) {
    return position;
  }

  /**
   * Add all the {@link Funcionario} into the Adapter.
   *
   * @param theFuncionarios to add.
   */
  public void setFuncionarios(List<Funcionario> theFuncionarios){
    this.funcionarios.addAll(theFuncionarios);
  }
  /**
   * Return a ConvertView with a Holder.
   *
   * @param position    to get.
   * @param convertView to use, can be null.
   * @param parent      the outer component.
   * @return the real ConverView.
   */
  @Override
  public View getView(int position, View convertView, ViewGroup parent) {

    // The holder
    ViewHolder holder;

    // Inflate only the rows visibles
    if (convertView == null) {
      convertView = this.theInflater.inflate(R.layout.row_funcionario, parent, false);

      // Contruct the ViewHolder
      holder = new ViewHolder(convertView);

      // Save into the convertView
      convertView.setTag(holder);

    } else {
      holder = (ViewHolder) convertView.getTag();
    }

    // Assign the values!
    final Funcionario funcionario = this.getItem(position);
    holder.nombre.setText(funcionario.getNombre());
    holder.email.setText(funcionario.getEmail());
    // TODO: Set all the attributes into the holder.

    return convertView;
  }

  /**
   * The ViewHolder.
   */
  private static class ViewHolder {

    // TODO: Add all the attributes!
    TextView nombre;
    TextView email;

    ViewHolder(View view) {
      this.nombre = view.findViewById(R.id.rf_tv_nombre);
      this.email = view.findViewById(R.id.rf_tv_email);
    }
  }
}
