package swing;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import swing.model.ConexaoDB;

@SuppressWarnings("serial")
public class QueryTableModel extends AbstractTableModel{

	private ArrayList<Object[]> linhas = new ArrayList<>();
	private String[] colunas;
	private Statement stmt;
	private String query;
	
	public QueryTableModel(String query) {
		try {
			this.query=query;
			stmt = ConexaoDB.getInstance().getConnection().createStatement();
			loadData();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void loadData() {
		System.out.println("QueryTableModel[load()]");
		try (ResultSet rs =stmt.executeQuery(query);){
			ResultSetMetaData rsmd = rs.getMetaData();
			int numCols = rsmd.getColumnCount();//recupera o npumero de colunas
		} catch (Exception e) {
			// TODO: handle exception
		}
				
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

}
