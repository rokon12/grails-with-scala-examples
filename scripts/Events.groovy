
eventCompileStart = {
    compileScalaSource()
}

private void compileScalaSource() {


    println "Start: Compiling Scala Source Code"

    ant.path(id: "scala.compile.classpath") {
        path(refid: "grails.compile.classpath")
    }

    ant.taskdef(name: 'scalac', classname: 'scala.tools.ant.Scalac', classpathref: "scala.compile.classpath")

    def scalaClassPath = classesDirPath


    try {
        def scalaSrcEncoding = 'UTF-8'

        println "Compiling Scala sources to $scalaClassPath"
        ant.mkdir(dir: scalaClassPath)
        ant.scalac(destdir: scalaClassPath,
                classpathref: "scala.compile.classpath",
                encoding: scalaSrcEncoding) {

            if (new File("${basedir}/src/scala").exists()) {
                src(path: "${basedir}/src/scala")
            }
            if (new File("${basedir}/src/java").exists()) {
                src(path: "${basedir}/src/java")
            }
        }

    } catch (Exception e) {
        Ant.fail(message: "Could not compile Scala sources: " + e.class.simpleName + ": " + e.message)
    }

    println "END: Compiling Scala Source Code"
}
