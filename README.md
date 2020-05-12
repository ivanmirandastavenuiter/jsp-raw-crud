# JSP raw crud

A crud based on Java Server Pages to show basic interactions with Java web features and classes.

## Implicit objects on JSP

* request --> **HttpServletRequest**
* response --> **HttpServletResponse**
* out --> **PrintWriter**
* session --> **HttpSession**
* application --> **ServletContext**
* config --> **ServletConfig**
* pageContext --> **PageContext**
* page --> **Object**
* exception --> **Throwable**

## Fist steps

**Application of filters in Login page**. This includes:

* Configuration of filters in web.xml file.
* Creation and customizing of LoginFilter filter type class (javax.servlet.Filters).
* Implementation of logger actions.
* **Second security validation layer**: first tier is performed at client with **JavaScript**. Second is done with **filters**.
* **Third security validation layer**: implementing on registration form. Almost done.

Third application security tier to be implemented through Java on plain JSP files.

:boom::boom::boom::boom::boom::boom::boom:

