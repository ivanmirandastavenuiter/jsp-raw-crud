# JSP raw crud

A crud based on Java Server Pages to show basic interactions with Java web features and classes.

Updates will be upload soon.

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

**COMPLETED**

1. Implement validation on register for unique usernames, email and phone. Done --> 5/12
2. Connect previous through JavaScript. Cookies maybe. Done --> 5/12
3. Show values introduced by user on forms when reloaded. Done --> 5/12
4. Exception handling. Done --> 5/14
5. Logger unification. Done --> 5/14
6. Injections code. Done --> 5/14

**TODOs**

1. Custom exceptions/Custom pages.
2. BouncyCastle AES encryption for passwords.
3. Correct dangerous casts to Object.

:boom::boom::boom::boom::boom::boom::boom:

