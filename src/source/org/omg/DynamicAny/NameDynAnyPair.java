package org.omg.DynamicAny;


/**
* org/omg/DynamicAny/NameDynAnyPair.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from /scratch/jenkins/workspace/8-2-build-linux-amd64/jdk8u331/2416/corba/src/share/classes/org/omg/DynamicAny/DynamicAny.idl
* Thursday, March 10, 2022 11:14:10 AM GMT
*/

public final class NameDynAnyPair implements org.omg.CORBA.portable.IDLEntity
{

  /**
          * The name associated with the DynAny.
          */
  public String id = null;

  /**
          * The DynAny value associated with the name.
          */
  public org.omg.DynamicAny.DynAny value = null;

  public NameDynAnyPair ()
  {
  } // ctor

  public NameDynAnyPair (String _id, org.omg.DynamicAny.DynAny _value)
  {
    id = _id;
    value = _value;
  } // ctor

} // class NameDynAnyPair
