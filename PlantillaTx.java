Connection cn = null;
try {
  // Obtener la conexión
  cn = AccesoDB.getConnection();
  // Habilitar la transacción
  cn.setAutoCommit(false);
  
  
  // Confimar transacción
  cn.commit();
} catch (SQLException e) {
  try {
	cn.rollback();
  } catch (Exception e1) {
  }
  throw new RuntimeException(e.getMessage());
} catch (Exception e) {
  try {
	cn.rollback();
  } catch (Exception e1) {
  }
  throw new RuntimeException("Error en el proceso Registrar Deposito, intentelo mas tarde.");
} finally{
  try {
	cn.close();
  } catch (Exception e) {
  }
} 