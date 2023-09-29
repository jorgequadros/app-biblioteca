package model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

import control.Categorias;

@SuppressWarnings({ "serial", "rawtypes" })
public class CategoriaComboboxModel extends AbstractListModel implements ComboBoxModel{

	private List <Categorias> listaCategorias;
	private Categorias categoriaSelecionada;
	
	public CategoriaComboboxModel() {
		this.listaCategorias = new ArrayList<>();
	}
	
	@Override
	public int getSize() {
		return listaCategorias.size();
	}

	@Override
	public Object getElementAt(int index) {
		return this.listaCategorias.get(index);
	}

	@Override
	public void setSelectedItem(Object anItem) {
		if(anItem instanceof Categorias) {
			this.categoriaSelecionada = (Categorias) anItem;
			fireContentsChanged(this.listaCategorias, 0, this.listaCategorias.size());
		}
	}

	@Override
	public Object getSelectedItem() {
		// TODO Auto-generated method stub
		return this.categoriaSelecionada;
	}
	
	public void addCategorias(Categorias categorias) {
		this.listaCategorias.add(categorias);
	}

}
