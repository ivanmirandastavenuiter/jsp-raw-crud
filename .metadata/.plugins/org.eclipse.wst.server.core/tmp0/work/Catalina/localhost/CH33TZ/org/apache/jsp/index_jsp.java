/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.30
 * Generated at: 2020-05-04 15:34:22 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Map;
import java.util.HashMap;
import java.util.Collection;
import java.util.Set;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar", Long.valueOf(1587638820007L));
    _jspx_dependants.put("jar:file:/C:/Users/IMS/Desktop/HACKING/WEB-DEVELOPMENT/JAVA/PROJECTS/CH33TZ-JSP/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/CH33TZ/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar!/META-INF/c.tld", Long.valueOf(1425975070000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.Map");
    _jspx_imports_classes.add("java.util.Collection");
    _jspx_imports_classes.add("java.util.Set");
    _jspx_imports_classes.add("java.util.HashMap");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Login</title>\r\n");
      out.write("<link href=\"https://fonts.googleapis.com/css?family=Merriweather&display=swap\" rel=\"stylesheet\">\r\n");
      out.write("<script type=\"module\" src=\"Validations/ValidationLogin.mjs\"></script>\r\n");
      out.write("<style>\r\n");
      out.write("\r\n");
      out.write("\tbody {\r\n");
      out.write("\t\tbackground: #464c80;\r\n");
      out.write("\t\tmargin: 0;\r\n");
      out.write("\t\tpadding: 0;\r\n");
      out.write("\t\theight: 100vh;\r\n");
      out.write("\t\twidth: 100vw;\r\n");
      out.write("\t\tfont-size: 62.5%; /* This is equivalent to 10px */\r\n");
      out.write("\t\tfont-family: 'Merriweather', serif;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tdiv.error-item {\r\n");
      out.write("\t\tmargin: 20px auto 0 auto;\r\n");
      out.write("    \twidth: 50%;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tdiv.error-item p {\r\n");
      out.write("\t    text-align: center;\r\n");
      out.write("\t    color: #e08787;\r\n");
      out.write("\t    font-size: 1.4em;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tdiv.main-container-div {\r\n");
      out.write("\t\theight: 100%;\r\n");
      out.write("\t\tdisplay: flex;\r\n");
      out.write("\t\tjustify-content: center;\r\n");
      out.write("\t\talign-items: center;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tdiv.form-container-div {\r\n");
      out.write("\t\tborder-radius: 6px;\r\n");
      out.write("\t\tbackground: #fff;\r\n");
      out.write("\t\twidth: 500px;\r\n");
      out.write("\t\tbox-shadow: 1px 1px 25px 1px #000; \r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tdiv.form-container-div form {\r\n");
      out.write("\t\tpadding: 10px 30px 30px 30px;\r\n");
      out.write("\t\tfont-size: 1.6em;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tdiv.form-container-div .login-div {\r\n");
      out.write("\t\tpadding: 10px;\r\n");
      out.write("\t\ttext-align: center;\r\n");
      out.write("\t\tborder-radius: 5px 5px 0 0;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tdiv.form-container-div .login-div h1 {\r\n");
      out.write("\t\tfont-size: 3.5em;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t/* Inside form-container-div */\r\n");
      out.write("\r\n");
      out.write("\t.inputs-group-div {\r\n");
      out.write("\t\tpadding: 15px;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t.inputs-group-div .input-div {\r\n");
      out.write("\t\twidth: 400px;\r\n");
      out.write("\t\tdisplay: flex;\r\n");
      out.write("\t\tjustify-content: space-between;\r\n");
      out.write("\t\talign-items: center;\r\n");
      out.write("\t\tmargin: 0 auto;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t.inputs-group-div .input-div .form-input {\r\n");
      out.write("\t\twidth: 63%;\r\n");
      out.write("\t\theight: 20px;\r\n");
      out.write("\t\tfont-family: inherit;\r\n");
      out.write("\t\tfont-size: .8em;\r\n");
      out.write("\t\toutline: none;\r\n");
      out.write("\t\tborder: 1px solid #464c80;\r\n");
      out.write("\t\tpadding: 5px;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t.inputs-group-div div[class$=\"wrong-validation-div\"] {\r\n");
      out.write("\t\tdisplay: flex;\r\n");
      out.write("\t\tjustify-content: flex-end;\r\n");
      out.write("\t\twidth: 400px;\r\n");
      out.write("\t\tmargin: 0 auto;\r\n");
      out.write("\t\topacity: 0;\r\n");
      out.write("\t\ttransition: opacity .5s linear;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t.inputs-group-div div[class$=\"wrong-validation-div\"] p {\r\n");
      out.write("\t\twidth: 63%;\r\n");
      out.write("\t\tpadding: 5px;\r\n");
      out.write("\t\tfont-size: .7em;\r\n");
      out.write("\t\tborder: 1px solid #e21010;\r\n");
      out.write("\t\tcolor: #e21010;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t.inputs-group-div .input-div label {\r\n");
      out.write("\t\theight: 20px;\r\n");
      out.write("\t\tpadding: 3px;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t.inputs-group-div .input-div .submit-btn {\r\n");
      out.write("\t\tfont-family: inherit;\r\n");
      out.write("\t\tfont-size: .8em;\r\n");
      out.write("\t\tmargin: 15px auto 5px auto;\r\n");
      out.write("\t\twidth: 40%;\r\n");
      out.write("\t\tpadding: 5px;\r\n");
      out.write("\t\tcolor: #fff;\r\n");
      out.write("\t\tbackground: #464c80;\r\n");
      out.write("\t\tborder-radius: 20px;\r\n");
      out.write("\t\theight: 30px;\r\n");
      out.write("\t\tborder: none;\r\n");
      out.write("\t\ttransition: background-color .3s linear;\r\n");
      out.write("\t\toutline: none;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t.inputs-group-div .register-link-div {\r\n");
      out.write("\t\ttext-align: center;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t.inputs-group-div .register-link-div span {\r\n");
      out.write("\t\tcolor: #464c80;\r\n");
      out.write("\t\tfont-size: 0.75em;\r\n");
      out.write("\t\tdisplay: block;\r\n");
      out.write("\t\tmargin-top: 10px;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t/* Buttons, boxes and links interactions */\r\n");
      out.write("\r\n");
      out.write("\t.inputs-group-div .input-div .submit-btn:hover {\r\n");
      out.write("\t\tbackground:#666dad;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t.inputs-group-div .input-div .submit-btn:active {\r\n");
      out.write("\t\tbackground: #272b50;\r\n");
      out.write("\t\ttransition: none;\r\n");
      out.write("\t\tborder: 1.5px solid #bfc4fd;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t.inputs-group-div .input-div .form-input:focus {\r\n");
      out.write("\t\tbackground: #d1d8f1;\r\n");
      out.write("\t\tborder: 1px solid #000;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t.inputs-group-div .form-input:-internal-autofill-selected {\r\n");
      out.write("\t\tbackground-color: #d1d8f1 !important;\r\n");
      out.write("\t\tborder: 1px solid #000 !important;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t.inputs-group-div .input-div .submit-btn:focus {\r\n");
      out.write("\t\tbackground: #272b50;\r\n");
      out.write("\t\ttransition: none;\r\n");
      out.write("\t\tborder: 1.5px solid #bfc4fd;\r\n");
      out.write("\t}\r\n");
      out.write(" \r\n");
      out.write("\t.inputs-group-div .register-link-div span a:visited,\r\n");
      out.write("\t.inputs-group-div .register-link-div span a:active {\r\n");
      out.write("\t\tcolor: inherit;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\t");
      if (_jspx_meth_c_005fset_005f0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      out.write('	');
      if (_jspx_meth_c_005fset_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t");
 
	
		Map errors = (HashMap)request.getAttribute("errors");
	
		if (errors != null) {
			
			
      out.write("\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_c_005fset_005f2(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_c_005fset_005f3(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t\t\t<div class=\"errors-container\">\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\t");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t");
      if (_jspx_meth_c_005fif_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t");

			
		}
		
	
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<!-- Main container -->\r\n");
      out.write("\t<div class=\"main-container-div\">\r\n");
      out.write("\r\n");
      out.write("\t\t<div class=\"form-container-div\">\r\n");
      out.write("\t\r\n");
      out.write("\t\t\t<!-- Login div -->\r\n");
      out.write("\t\t\t<div class=\"login-div\">\r\n");
      out.write("\t\t\t\t<h1>Login</h1>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<!-- Form -->\r\n");
      out.write("\t\t\t<form name=\"loginForm\" method=\"post\" action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${actionPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<div class=\"inputs-group-div\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<!-- Input items -->\r\n");
      out.write("\t\t\t\t\t<div class=\"input-div\">\r\n");
      out.write("\t\t\t\t\t\t<label for=\"username\">Username</label>\r\n");
      out.write("\t\t\t\t\t\t<input class=\"form-input\" type=\"text\" name=\"username\"/>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<div class=\"username-wrong-validation-div\">\r\n");
      out.write("\t\t\t\t\t\t<p class=\"username-wrong-validation\"></p>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<div class=\"input-div\">\r\n");
      out.write("\t\t\t\t\t\t<label for=\"pass\">Password</label>\r\n");
      out.write("\t\t\t\t\t\t<input class=\"form-input\" type=\"password\" name=\"pass\"/>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<div class=\"password-wrong-validation-div\">\r\n");
      out.write("\t\t\t\t\t\t<p class=\"password-wrong-validation\"></p>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<div class=\"input-div\">\r\n");
      out.write("\t\t\t\t\t\t<input class=\"submit-btn\" type=\"submit\" value=\"Submit\"/>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<div class=\"register-link-div\">\r\n");
      out.write("\t\t\t\t\t\t<span><a href=\"register.jsp\">I'm not a user yet</a></span>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fset_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    boolean _jspx_th_c_005fset_005f0_reused = false;
    try {
      _jspx_th_c_005fset_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fset_005f0.setParent(null);
      // /index.jsp(173,1) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fset_005f0.setVar("contextPath");
      // /index.jsp(173,1) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
      _jspx_th_c_005fset_005f0.setValue(new org.apache.jasper.el.JspValueExpression("/index.jsp(173,1) '${pageContext.request.contextPath}'",_jsp_getExpressionFactory().createValueExpression(_jspx_page_context.getELContext(),"${pageContext.request.contextPath}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
      int _jspx_eval_c_005fset_005f0 = _jspx_th_c_005fset_005f0.doStartTag();
      if (_jspx_th_c_005fset_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
      _jspx_th_c_005fset_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fset_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fset_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f1 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    boolean _jspx_th_c_005fset_005f1_reused = false;
    try {
      _jspx_th_c_005fset_005f1.setPageContext(_jspx_page_context);
      _jspx_th_c_005fset_005f1.setParent(null);
      // /index.jsp(174,1) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fset_005f1.setVar("actionPath");
      // /index.jsp(174,1) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
      _jspx_th_c_005fset_005f1.setValue(new org.apache.jasper.el.JspValueExpression("/index.jsp(174,1) '${contextPath}/JSP/welcome.jsp'",_jsp_getExpressionFactory().createValueExpression(_jspx_page_context.getELContext(),"${contextPath}/JSP/welcome.jsp",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
      int _jspx_eval_c_005fset_005f1 = _jspx_th_c_005fset_005f1.doStartTag();
      if (_jspx_th_c_005fset_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f1);
      _jspx_th_c_005fset_005f1_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fset_005f1, _jsp_getInstanceManager(), _jspx_th_c_005fset_005f1_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f2(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f2 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    boolean _jspx_th_c_005fset_005f2_reused = false;
    try {
      _jspx_th_c_005fset_005f2.setPageContext(_jspx_page_context);
      _jspx_th_c_005fset_005f2.setParent(null);
      // /index.jsp(184,3) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fset_005f2.setVar("usernameError");
      // /index.jsp(184,3) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
      _jspx_th_c_005fset_005f2.setValue(new org.apache.jasper.el.JspValueExpression("/index.jsp(184,3) '${errors.username}'",_jsp_getExpressionFactory().createValueExpression(_jspx_page_context.getELContext(),"${errors.username}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
      int _jspx_eval_c_005fset_005f2 = _jspx_th_c_005fset_005f2.doStartTag();
      if (_jspx_th_c_005fset_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f2);
      _jspx_th_c_005fset_005f2_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fset_005f2, _jsp_getInstanceManager(), _jspx_th_c_005fset_005f2_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f3(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f3 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    boolean _jspx_th_c_005fset_005f3_reused = false;
    try {
      _jspx_th_c_005fset_005f3.setPageContext(_jspx_page_context);
      _jspx_th_c_005fset_005f3.setParent(null);
      // /index.jsp(185,3) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fset_005f3.setVar("passwordError");
      // /index.jsp(185,3) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
      _jspx_th_c_005fset_005f3.setValue(new org.apache.jasper.el.JspValueExpression("/index.jsp(185,3) '${errors.password}'",_jsp_getExpressionFactory().createValueExpression(_jspx_page_context.getELContext(),"${errors.password}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
      int _jspx_eval_c_005fset_005f3 = _jspx_th_c_005fset_005f3.doStartTag();
      if (_jspx_th_c_005fset_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f3);
      _jspx_th_c_005fset_005f3_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fset_005f3, _jsp_getInstanceManager(), _jspx_th_c_005fset_005f3_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f0_reused = false;
    try {
      _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f0.setParent(null);
      // /index.jsp(189,4) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${not empty usernameError}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
      if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t<div class=\"error-item\">\r\n");
          out.write("\t\t\t\t\t\t<p>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${usernameError}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("</p>\r\n");
          out.write("\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      _jspx_th_c_005fif_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f1_reused = false;
    try {
      _jspx_th_c_005fif_005f1.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f1.setParent(null);
      // /index.jsp(195,4) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${not empty passwordError}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f1 = _jspx_th_c_005fif_005f1.doStartTag();
      if (_jspx_eval_c_005fif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t<div class=\"error-item\">\r\n");
          out.write("\t\t\t\t\t\t<p>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${passwordError}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("</p>\r\n");
          out.write("\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fif_005f1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
      _jspx_th_c_005fif_005f1_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f1, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f1_reused);
    }
    return false;
  }
}
