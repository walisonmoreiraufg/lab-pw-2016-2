package resteasy;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/api")
public class RestEasyApplication extends Application {

  private Set<Object> singletons = new HashSet<Object>();

  @Override
  public Set<Object> getSingletons() {
    return singletons;
  }
  
  public RestEasyApplication() {
    singletons.add(new AlunoController());
  }
  
}