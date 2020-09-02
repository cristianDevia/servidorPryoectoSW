package model;

import DB.ConexionBD;

import estructural.Estudiante;
import estructural.Matricula;
import estructural.ProgramaAcademico;
import estructural.Universidad;

import java.sql.ResultSet;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(serviceName = "ServicioUniversidadSW")
public class ServicioUniversidadSW {
   
    /*public ServicioUniversidadSW() {
        super();
    }*/
    
    private static ArrayList<Estudiante> estudiantes = new ArrayList();   
    private static ArrayList<Matricula> matriculas = new ArrayList();
    private static ArrayList<ProgramaAcademico> programa = new ArrayList();
    private static ServicioUniversidad servicio = new ServicioUniversidad();
    
     
     ConexionBD conexion;
     
     public ServicioUniversidadSW()
     {
         servicio.ServicioUniversidad();
     }


    @Oneway
    @WebMethod
    public void cargarDatosEstudiantes(){

     try{
         servicio.cargarDatosEstudiantes();
     }
     catch(Exception e)
     {
       e.printStackTrace();
     }
     }

    @Oneway
    @WebMethod
    public void cargarDatosMatricula(){

     try{  
            servicio.cargarDatosMatricula(); 
         }
         
     catch(Exception e)
     {
       e.printStackTrace();
     }
     }

    @Oneway
    @WebMethod
    public void cargarDatosPrograma(){

     try{  
            servicio.cargarDatosPrograma();
         }
     catch(Exception e)
     {
       e.printStackTrace();
     }
     }


    @Oneway
    @WebMethod
    public void anadirEstudiante(@WebParam(name = "arg0") Estudiante estu)
     {
        servicio.anadirEstudiante(estu); 
     }

    @Oneway
    @WebMethod
    public void anadirMatricula(@WebParam(name = "arg0") Matricula matricula)
     {
        servicio.anadirMatricula(matricula);    
     }


    @Oneway
    @WebMethod
    public void eliminarPorCodigoEstudiante(@WebParam(name = "arg0") String pCodigo)
     {
        servicio.eliminarPorCodigoEstudiante(pCodigo);   
     }


    @Oneway
    @WebMethod
    public void eliminarPorNumeroMatricula(@WebParam(name = "arg0") String pCodigo)
     {
        servicio.eliminarPorNumeroMatricula(pCodigo);
     }


    @Oneway
    @WebMethod
    public void actualizarEstudiantePorCodigo(@WebParam(name = "arg0") String nombre,
                                              @WebParam(name = "arg1") int cedula,
                                              @WebParam(name = "arg2") String codigo,
                                              @WebParam(name = "arg3") String correo,
                                              @WebParam(name = "arg4") int celular,
                                              @WebParam(name = "arg5") Date fechaNacimiento,
                                              @WebParam(name = "arg6") String genero)
     {
        servicio.actualizarEstudiantePorCodigo(nombre, cedula, codigo, correo, celular, fechaNacimiento, genero);
     }


    @Oneway
    @WebMethod
    public void actualizarMatricula(@WebParam(name = "arg0") int numeroMatricula,
                                    @WebParam(name = "arg1") int numCreditos,
                                    @WebParam(name = "arg2") Date fechaIngreso, @WebParam(name = "arg3") double valor,
                                    @WebParam(name = "arg4") double ppa)
     {
        servicio.actualizarMatricula(numeroMatricula, numCreditos, fechaIngreso, valor, ppa);
     }


    @WebMethod
    public ArrayList listarEstudiantes()
     {   
        return servicio.listarEstudiantes();
     }

    @WebMethod
    public ArrayList listarMatriculas()
     {   
        return servicio.listarMatriculas();
     }

    @WebMethod
    public ArrayList listarProgramas()
     {   
        return servicio.listarProgramas();
     }

    @WebMethod
    public Estudiante buscarEstudiantePorCodigo(@WebParam(name = "arg0") String codigo)
      { 
        return servicio.buscarEstudiantePorCodigo(codigo);
      }


    @WebMethod
    public Matricula buscarMatricula(@WebParam(name = "arg0") String codigo )
      {
        return servicio.buscarMatricula(codigo);
      }

    @WebMethod
    public ArrayList<Estudiante> getEstudiantes() {
            return servicio.getEstudiantes();
        }

    @WebMethod
    public ArrayList<Matricula> getMatriculas() {
           return servicio.getMatriculas();
        }

    @WebMethod
    public ArrayList<ProgramaAcademico> getProgramas() {
           return servicio.getPrograma();
        }
}
