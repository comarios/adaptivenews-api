// @SOURCE:/Users/marios/Documents/workspace/adaptivenewsapi/conf/routes
// @HASH:3a115f9a73d78910a08ad67fb21ef2c47921daae
// @DATE:Wed Nov 19 17:08:01 GMT 2014


import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString

object Routes extends Router.Routes {

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:6
private[this] lazy val controllers_Application_index0 = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
        

// @LINE:10
private[this] lazy val controllers_Assets_at1 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
        

// @LINE:12
private[this] lazy val controllers_UM_getUserClass2 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("um/getUserClass"))))
        

// @LINE:13
private[this] lazy val controllers_Users_getUsers3 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("users/all"))))
        

// @LINE:14
private[this] lazy val controllers_Users_isEmailUnique4 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("users/isEmailUnique/"),DynamicPart("email_address", """[^/]+""",true))))
        

// @LINE:15
private[this] lazy val controllers_Users_login5 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("users/login"))))
        

// @LINE:16
private[this] lazy val controllers_Users_addUser6 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("users/addUser"))))
        

// @LINE:17
private[this] lazy val controllers_Users_storeReadingBehavior7 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("users/storeReadingBehavior"))))
        

// @LINE:18
private[this] lazy val controllers_Users_storeNavigationBehavior8 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("users/storeNavigationBehavior"))))
        

// @LINE:19
private[this] lazy val controllers_Users_storeReadingScroll9 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("users/storeReadingScroll"))))
        

// @LINE:20
private[this] lazy val controllers_Users_storeNavigationalMetaData10 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("users/storeNavigationalMetaData"))))
        

// @LINE:21
private[this] lazy val controllers_Users_storeRunningNewsApps11 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("users/storeRunningNewsApps"))))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """um/getUserClass""","""controllers.UM.getUserClass()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """users/all""","""controllers.Users.getUsers()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """users/isEmailUnique/$email_address<[^/]+>""","""controllers.Users.isEmailUnique(email_address:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """users/login""","""controllers.Users.login()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """users/addUser""","""controllers.Users.addUser()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """users/storeReadingBehavior""","""controllers.Users.storeReadingBehavior()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """users/storeNavigationBehavior""","""controllers.Users.storeNavigationBehavior()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """users/storeReadingScroll""","""controllers.Users.storeReadingScroll()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """users/storeNavigationalMetaData""","""controllers.Users.storeNavigationalMetaData()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """users/storeRunningNewsApps""","""controllers.Users.storeRunningNewsApps()""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]] 
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:6
case controllers_Application_index0(params) => {
   call { 
        invokeHandler(controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Nil,"GET", """ Home page""", Routes.prefix + """"""))
   }
}
        

// @LINE:10
case controllers_Assets_at1(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
   }
}
        

// @LINE:12
case controllers_UM_getUserClass2(params) => {
   call { 
        invokeHandler(controllers.UM.getUserClass(), HandlerDef(this, "controllers.UM", "getUserClass", Nil,"POST", """""", Routes.prefix + """um/getUserClass"""))
   }
}
        

// @LINE:13
case controllers_Users_getUsers3(params) => {
   call { 
        invokeHandler(controllers.Users.getUsers(), HandlerDef(this, "controllers.Users", "getUsers", Nil,"GET", """""", Routes.prefix + """users/all"""))
   }
}
        

// @LINE:14
case controllers_Users_isEmailUnique4(params) => {
   call(params.fromPath[String]("email_address", None)) { (email_address) =>
        invokeHandler(controllers.Users.isEmailUnique(email_address), HandlerDef(this, "controllers.Users", "isEmailUnique", Seq(classOf[String]),"GET", """""", Routes.prefix + """users/isEmailUnique/$email_address<[^/]+>"""))
   }
}
        

// @LINE:15
case controllers_Users_login5(params) => {
   call { 
        invokeHandler(controllers.Users.login(), HandlerDef(this, "controllers.Users", "login", Nil,"POST", """""", Routes.prefix + """users/login"""))
   }
}
        

// @LINE:16
case controllers_Users_addUser6(params) => {
   call { 
        invokeHandler(controllers.Users.addUser(), HandlerDef(this, "controllers.Users", "addUser", Nil,"POST", """""", Routes.prefix + """users/addUser"""))
   }
}
        

// @LINE:17
case controllers_Users_storeReadingBehavior7(params) => {
   call { 
        invokeHandler(controllers.Users.storeReadingBehavior(), HandlerDef(this, "controllers.Users", "storeReadingBehavior", Nil,"POST", """""", Routes.prefix + """users/storeReadingBehavior"""))
   }
}
        

// @LINE:18
case controllers_Users_storeNavigationBehavior8(params) => {
   call { 
        invokeHandler(controllers.Users.storeNavigationBehavior(), HandlerDef(this, "controllers.Users", "storeNavigationBehavior", Nil,"POST", """""", Routes.prefix + """users/storeNavigationBehavior"""))
   }
}
        

// @LINE:19
case controllers_Users_storeReadingScroll9(params) => {
   call { 
        invokeHandler(controllers.Users.storeReadingScroll(), HandlerDef(this, "controllers.Users", "storeReadingScroll", Nil,"POST", """""", Routes.prefix + """users/storeReadingScroll"""))
   }
}
        

// @LINE:20
case controllers_Users_storeNavigationalMetaData10(params) => {
   call { 
        invokeHandler(controllers.Users.storeNavigationalMetaData(), HandlerDef(this, "controllers.Users", "storeNavigationalMetaData", Nil,"POST", """""", Routes.prefix + """users/storeNavigationalMetaData"""))
   }
}
        

// @LINE:21
case controllers_Users_storeRunningNewsApps11(params) => {
   call { 
        invokeHandler(controllers.Users.storeRunningNewsApps(), HandlerDef(this, "controllers.Users", "storeRunningNewsApps", Nil,"POST", """""", Routes.prefix + """users/storeRunningNewsApps"""))
   }
}
        
}

}
     