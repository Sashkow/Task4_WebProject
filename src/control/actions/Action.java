package control.actions;

/**
 * Created by root on 09.02.14.
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
