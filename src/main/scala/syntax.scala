abstract class Term
case class Call(objName: String, metName: String) extends Term
case class Var(name: String) extends Term
case class App(funName: String, argName: String) extends Term
case class Let(varName: String, varDef: Term, scope: Term) extends Term
case class Object(name: String, body: List[Decl]) extends Term
case class Abs(varName: String, argType: Type, body: Term) extends Term

abstract class Decl
case class FieldDef(name: String, body: Term) extends Decl
case class TypeDef(name: String, typ: Type) extends Decl
case class Agg(decls: List[Decl]) extends Decl

abstract class Type
case object Top extends Type 
case object Bot extends Type 
case object IntT extends Type
case class SetT(typ: Type) extends Type
case class SortedSetT(typ: Type) extends Type
case class Intersec(a: Type, b: Type) extends Type
//case class FieldDec(name: String, typ: Type) extends Type
//case class Rec(name: String, typ: Type) extends Type
//case class TypeDec(name: String, lower: Type, upper: Type) extends Type
//case class TypeProj(typ: Type, name: String) extends Type
//case class DepFun(name: String, argType: Type, retType: Type) extends Type
//case class ImDepFun(name: String, argType: Type, retType: Type) extends Type

object prettyPrint {
  def apply(term: Term): String = term match {
    case Call(objName, metName) => s"$objName.$metName"
    case Var(name) => name
    case App(funName, argName) => s"$funName($argName)"
    case Let(varName, varDef, scope) => s"val $varName = $varDef\n$scope"
    case Object(name, body) => s"new { val $name = this\n$body }"
    case Abs(varName, argType, body) => s"{ $varName: $argType => $body }"
  }
  def apply(decl: Decl) = decl match {
    case FieldDef(name, body) => s"val $name = $body"
    case TypeDef(name, typ) => s"type $name = $typ"
    case Agg(decls) => decls mkString "\n"
  }
  def apply(typ: Type) = typ match {
    case Top => "AnyRef"
    case Bot => "Nothing"
    case IntT => "Int"
    case SetT(typ) => s"Set[$typ]"
    case SortedSetT(typ) => s"SortedSet[$typ]"
    case Intersec(a, b) => s"$a with $b"
    //case FieldDec(name, typ) => ???
    //case Rec(name, typ) => ???
    //case TypeDec(name, lower, upper) => ???
    //case TypeProj(typ, name) => ???
    //case DepFun(name, argType, retType) => ???
    //case ImDepFun(name, argType, retType) => ???
  }
}
