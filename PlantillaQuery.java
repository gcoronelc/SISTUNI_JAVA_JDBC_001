Connection cn = null;
try {
  cn = AccesoDB.getConnection();
  
} catch (SQLException e) {
  throw new RuntimeException(e.getMessage());
} catch (Exception e) {
  e.printStackTrace();
  String msg = "Error en el proceso de validación.";
  if(e.getMessage() != null){
	msg += "\n" + e.getMessage();
  }
  throw new RuntimeException(msg);
} finally {
  try {
	cn.close();
  } catch (Exception e) {
  }
}