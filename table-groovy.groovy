@Grab('com.fasterxml.jackson.core:jackson-databind:2.13.0')
import com.fasterxml.jackson.databind.ObjectMapper
import groovy.json.JsonSlurper

// Nombre del archivo JSON
def archivoJson = "datos.json"

// Leer el archivo JSON
def json = new JsonSlurper().parse(new File(archivoJson))

// Crear tabla de datos
def tablaDatos = [
    ["Campo", "Valor"],
    ["Nombre", json.persona.nombre],
    ["Edad", json.persona.edad],
    ["Ciudad", json.persona.direccion.ciudad],
    ["Código Postal", json.persona.direccion.codigo_postal]
]

// Imprimir tabla en la consola
println formatTabla(tablaDatos)

// Función para formatear la tabla
def formatTabla(tabla) {
    def anchoColumnas = tabla.transpose().collect { columna ->
        columna.inject(0) { max, valor -> Math.max(max, valor.toString().length()) }
    }
    
    def formato = tabla.collect { fila ->
        fila.collectWithIndex { valor, indice ->
            valor.toString().padRight(anchoColumnas[indice])
        }.join(' | ')
    }
    
    def separador = anchoColumnas.collect { '-' * it }.join('-+-')
    
    "${formato.join('\n')}\n${separador}"
}
