# CH33TZ PROJECT - JSP RAW CRUD

A crud based on Java Server Pages to show basic interactions with Java web features and classes. 

It is also the beginning of CH33TZ project taking shape.

LAST UPDATE :point_right: 5/21

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

## Production steps

**Login/Register structure implmented**. This includes:

* Views for user interfaces in JSP.
* Configuration of filters in web.xml file. LoginFilter and RegisterFilter (javax.servlet.Filters).
* Implementation of logger actions.
* Exception handling.
* **First security validation layer**: JavaScript on the client.
* **Second security validation layer**: Java **filters**.
* **Third security validation layer**: Java scripts directly on JSP.
* **Fourth security validation layer**: Triggers on database.

**Inserting design on pages with CSS and HTML**.

**COMPLETED**

1. Implement validation on register for unique usernames, email and phone. Done --> 5/12
2. Connect previous through JavaScript. Cookies maybe. Done --> 5/12
3. Show values introduced by user on forms when reloaded. Done --> 5/12
4. Exception handling. Done --> 5/14
5. Logger unification. Done --> 5/14
6. Injections code. Done --> 5/14
7. BouncyCastle AES encryption for passwords. Done --> 5/21

**TODOs**

1. Custom exceptions/Custom pages. **PRIO: min**
2. Correct dangerous casts to Object. **PRIO: min**
3. Main page HTML/CSS design for welcome page. **PRIO: high**

:boom::boom::boom::boom::boom::boom::boom:

