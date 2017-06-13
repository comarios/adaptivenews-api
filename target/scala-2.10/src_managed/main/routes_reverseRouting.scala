// @SOURCE:/Users/marios/Documents/workspace/adaptivenewsapi/conf/routes
// @HASH:3a115f9a73d78910a08ad67fb21ef2c47921daae
// @DATE:Wed Nov 19 17:08:01 GMT 2014

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString


// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:10
// @LINE:6
package controllers {

// @LINE:12
class ReverseUM {
    

// @LINE:12
def getUserClass(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "um/getUserClass")
}
                                                
    
}
                          

// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
class ReverseUsers {
    

// @LINE:16
def addUser(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "users/addUser")
}
                                                

// @LINE:17
def storeReadingBehavior(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "users/storeReadingBehavior")
}
                                                

// @LINE:13
def getUsers(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "users/all")
}
                                                

// @LINE:18
def storeNavigationBehavior(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "users/storeNavigationBehavior")
}
                                                

// @LINE:20
def storeNavigationalMetaData(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "users/storeNavigationalMetaData")
}
                                                

// @LINE:14
def isEmailUnique(email_address:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "users/isEmailUnique/" + implicitly[PathBindable[String]].unbind("email_address", dynamicString(email_address)))
}
                                                

// @LINE:21
def storeRunningNewsApps(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "users/storeRunningNewsApps")
}
                                                

// @LINE:19
def storeReadingScroll(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "users/storeReadingScroll")
}
                                                

// @LINE:15
def login(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "users/login")
}
                                                
    
}
                          

// @LINE:10
class ReverseAssets {
    

// @LINE:10
def at(file:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                
    
}
                          

// @LINE:6
class ReverseApplication {
    

// @LINE:6
def index(): Call = {
   Call("GET", _prefix)
}
                                                
    
}
                          
}
                  


// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:10
// @LINE:6
package controllers.javascript {

// @LINE:12
class ReverseUM {
    

// @LINE:12
def getUserClass : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.UM.getUserClass",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "um/getUserClass"})
      }
   """
)
                        
    
}
              

// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
class ReverseUsers {
    

// @LINE:16
def addUser : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Users.addUser",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "users/addUser"})
      }
   """
)
                        

// @LINE:17
def storeReadingBehavior : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Users.storeReadingBehavior",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "users/storeReadingBehavior"})
      }
   """
)
                        

// @LINE:13
def getUsers : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Users.getUsers",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "users/all"})
      }
   """
)
                        

// @LINE:18
def storeNavigationBehavior : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Users.storeNavigationBehavior",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "users/storeNavigationBehavior"})
      }
   """
)
                        

// @LINE:20
def storeNavigationalMetaData : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Users.storeNavigationalMetaData",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "users/storeNavigationalMetaData"})
      }
   """
)
                        

// @LINE:14
def isEmailUnique : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Users.isEmailUnique",
   """
      function(email_address) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "users/isEmailUnique/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("email_address", encodeURIComponent(email_address))})
      }
   """
)
                        

// @LINE:21
def storeRunningNewsApps : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Users.storeRunningNewsApps",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "users/storeRunningNewsApps"})
      }
   """
)
                        

// @LINE:19
def storeReadingScroll : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Users.storeReadingScroll",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "users/storeReadingScroll"})
      }
   """
)
                        

// @LINE:15
def login : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Users.login",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "users/login"})
      }
   """
)
                        
    
}
              

// @LINE:10
class ReverseAssets {
    

// @LINE:10
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        
    
}
              

// @LINE:6
class ReverseApplication {
    

// @LINE:6
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        
    
}
              
}
        


// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:10
// @LINE:6
package controllers.ref {


// @LINE:12
class ReverseUM {
    

// @LINE:12
def getUserClass(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.UM.getUserClass(), HandlerDef(this, "controllers.UM", "getUserClass", Seq(), "POST", """""", _prefix + """um/getUserClass""")
)
                      
    
}
                          

// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
class ReverseUsers {
    

// @LINE:16
def addUser(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Users.addUser(), HandlerDef(this, "controllers.Users", "addUser", Seq(), "POST", """""", _prefix + """users/addUser""")
)
                      

// @LINE:17
def storeReadingBehavior(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Users.storeReadingBehavior(), HandlerDef(this, "controllers.Users", "storeReadingBehavior", Seq(), "POST", """""", _prefix + """users/storeReadingBehavior""")
)
                      

// @LINE:13
def getUsers(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Users.getUsers(), HandlerDef(this, "controllers.Users", "getUsers", Seq(), "GET", """""", _prefix + """users/all""")
)
                      

// @LINE:18
def storeNavigationBehavior(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Users.storeNavigationBehavior(), HandlerDef(this, "controllers.Users", "storeNavigationBehavior", Seq(), "POST", """""", _prefix + """users/storeNavigationBehavior""")
)
                      

// @LINE:20
def storeNavigationalMetaData(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Users.storeNavigationalMetaData(), HandlerDef(this, "controllers.Users", "storeNavigationalMetaData", Seq(), "POST", """""", _prefix + """users/storeNavigationalMetaData""")
)
                      

// @LINE:14
def isEmailUnique(email_address:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Users.isEmailUnique(email_address), HandlerDef(this, "controllers.Users", "isEmailUnique", Seq(classOf[String]), "GET", """""", _prefix + """users/isEmailUnique/$email_address<[^/]+>""")
)
                      

// @LINE:21
def storeRunningNewsApps(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Users.storeRunningNewsApps(), HandlerDef(this, "controllers.Users", "storeRunningNewsApps", Seq(), "POST", """""", _prefix + """users/storeRunningNewsApps""")
)
                      

// @LINE:19
def storeReadingScroll(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Users.storeReadingScroll(), HandlerDef(this, "controllers.Users", "storeReadingScroll", Seq(), "POST", """""", _prefix + """users/storeReadingScroll""")
)
                      

// @LINE:15
def login(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Users.login(), HandlerDef(this, "controllers.Users", "login", Seq(), "POST", """""", _prefix + """users/login""")
)
                      
    
}
                          

// @LINE:10
class ReverseAssets {
    

// @LINE:10
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      
    
}
                          

// @LINE:6
class ReverseApplication {
    

// @LINE:6
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Seq(), "GET", """ Home page""", _prefix + """""")
)
                      
    
}
                          
}
        
    