package com.nehru.designpatterns.structural;


/**
 * The interface Database executor.
 */
interface DatabaseExecutor {

  /**
   * Execute.
   *
   * @param query the query
   * @param role  the role
   */
  void execute(String query, String role);
}

/**
 * The type Proxy pattern demo. Real service and proxy service is implemented by same interface and
 * proxy is being called and allows call to real service only if the condition meets
 */
public class ProxyPatternDemo {


  /**
   * Main.
   *
   * @param args the args
   */
  public static void main(String[] args) {
    DatabaseExecutor databaseExecutor = new OracleDatabaseExecutorProxy();

    databaseExecutor.execute("ADD", "NON_ADMIN");
    databaseExecutor.execute("ADD", "ADMIN");

    databaseExecutor.execute("DELETE", "ADMIN");
    databaseExecutor.execute("DELETE", "NON_ADMIN");
  }

}

/**
 * The type Oracle database executor.
 */
class OracleDatabaseExecutor implements DatabaseExecutor {

  @Override
  public void execute(String query, String role) {
    System.out.printf("%s operation is executed by %s %n", query, role);
  }

}

/**
 * The type Oracle database executor proxy.
 */
class OracleDatabaseExecutorProxy implements DatabaseExecutor {

  /**
   * The Oracle database executor.
   */
  OracleDatabaseExecutor oracleDatabaseExecutor;

  @Override
  public void execute(String query, String role) {
    if ("DELETE".equals(query)) {
      if ("ADMIN".equals(role)) {
        oracleDatabaseExecutor = new OracleDatabaseExecutor();
        oracleDatabaseExecutor.execute(query, role);
      } else {
        throw new RuntimeException(role + " is not allowed to execute DELETE operation");
      }

    } else {
      oracleDatabaseExecutor = new OracleDatabaseExecutor();
      oracleDatabaseExecutor.execute(query, role);
    }
  }

}
