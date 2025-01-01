package il.co.ilrd.book.java;

public class Q {

    /*
    1.1 Private Constructor: In terms of inheritance, what is the effect of keeping a constructor private?

    SOLUTION
    Prevents Subclassing - A private constructor prevents the class from being subclassed because
    subclasses cannot access a private constructor.

    Usage in Singleton Design
    Static Factory or Utility Classes
    Limited Instantiation Control


    1.3 Final, etc.: What is the difference between final, finally, and finalize?

    Despite their similar sounding names, final, finally and finalize have very different purposes.
    To speak in very general terms, final is used to control whether a variable, method, or class is "change
    able:' The finally keyword is used in a try/ catch block to ensure that a segment of code is always
    executed. The finalize() method is called by the garbage collector once it determines that no more
    references exist.

    final
        The final statement has a different meaning depending on its context.
        When applied to a variable (primitive):The value of the variable cannot change.
        • When applied to a variable (reference): The reference variable cannot point to any other object on the
        heap.
        • When applied to a method: The method cannot be overridden.
        • When applied to a class:The class cannot be subclassed.




     1.4 Generics vs. Templates: Explain the difference between templates in C ++ and generics in Java

     Many programmers consider templates and generics to be essentially equivalent because both allow you
    to do something like List<String>. But, how each language does this, and why, varies significantly.
    The implementation of Java generics is rooted in an idea of"type erasure:'This technique eliminates the
    parameterized types when source code is translated to the Java Virtual Machine (JVM) byte code.

    For example, suppose you have the Java code below:
        1 Vector<String> vector = new Vector<String>();
        2 vector.add(new String("hello"));
        3 String str = vector.get(0);
    During compilation, this code is re-written into:
        1 Vector vector = new Vector();
        2 vector. add(new String("hello"));
        3 String str = (String) vector.get(0);

        java generics and C++ templates have a number of other differences. These include:
        C++ templates can use primitive types, like int. Java cannot and must instead use Integer.
        In Java, you can restrict the template's type parameters to be of a certain type. For instance, you might use
        generics to implement a CardDeck and specify that the type parameter must extend from CardGame.
        In C++, the type parameter can be instantiated, whereas Java does not support this.
        In Java, the type parameter (i.e., the Foo in MyClass<Foo>) cannot be used for static methods and
        variables, since these would be shared between MyClass<Foo> and MyClass<Bar>. In C++, these
        classes are different, so the type parameter can be used for static methods and variables.
        In Java, all instances of MyClass, regardless of their type parameters, are the same type. The type
        parameters are erased at runtime. In C++, instances with different type parameters are different types.
        Remember: Although Java generics and C++ templates look the same in many ways, they are very differen


        1.5 Object Reflection: Explain what object reflection is in Java and why it is useful

        Object Reflection is a feature in Java that provides a way to get reflective information about Java classes and
        objects, and perform operations such as:
            1. Getting information about the methods and fields present inside the class at runtime.
            2. Creating a new instance of a class.
            3. Getting and setting the object fields directly by getting field reference, regardless of what the access
            modifier is.

     */



}
