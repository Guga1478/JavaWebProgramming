package ar.com.centroeducativo.controlador;

import ar.com.centroeducativo.config.GenerarSerie;
import ar.com.centroeducativo.modelo.Alumno;
import ar.com.centroeducativo.modelo.AlumnoDAO;
import ar.com.centroeducativo.modelo.Inscripcion;
import ar.com.centroeducativo.modelo.InscripcionDAO;
import ar.com.centroeducativo.modelo.Materias;
import ar.com.centroeducativo.modelo.MateriasDAO;
import ar.com.centroeducativo.modelo.Profesor;
import ar.com.centroeducativo.modelo.ProfesorDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controlador extends HttpServlet {
    Alumno alu = new Alumno();
    AlumnoDAO adao = new AlumnoDAO();
    Profesor pr = new Profesor();
    ProfesorDAO pdao = new ProfesorDAO();
    Materias ma = new Materias();
    MateriasDAO mdao = new MateriasDAO();
    int ida;
    int idp;
    int idm;
    
    Inscripcion insc = new Inscripcion();
    List<Inscripcion>lista=new ArrayList<>();    
    int item;
    int cod;
    String descripcion;    
    int cant;
    
    String numeroserie;
    InscripcionDAO idao = new InscripcionDAO();
    

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        if (menu.equals("Principal")) {
            request.getRequestDispatcher("Principal.jsp").forward(request, response);
        }
        if (menu.equals("Alumno")) {
            switch (accion) {
                case "Listar":
                    List lista = adao.listar();
                    request.setAttribute("alumnos", lista);
                    break;
                case "Agregar":
                    String nom = request.getParameter("txtNombres");
                    String dni = request.getParameter("txtDni");
                    int idm = Integer.parseInt(request.getParameter("codigomateria"));
                    String user = request.getParameter("txtUser");
                    alu.setNombres(nom);
                    alu.setDni(dni);
                    alu.setIdMaterias(idm);
                    alu.setUser(user);
                    adao.agregar(alu);
                    request.setAttribute("alu", alu);
                    request.setAttribute("materias", ma);
                    request.getRequestDispatcher("Controlador?menu=Alumno&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    ida = Integer.parseInt(request.getParameter("id"));
                    Alumno al = adao.listarId(ida);
                    request.setAttribute("alumno", al);
                    request.getRequestDispatcher("Controlador?menu=Alumno&accion=Listar").forward(request, response);
                    break;
                case "Alta":    
                    ida = Integer.parseInt(request.getParameter("id"));
                    Alumno alum = adao.listarId(ida);
                    request.getRequestDispatcher("Inscripcion.jsp").forward(request, response);
                    break;
                case "Actualizar":  
                    String nom1 = request.getParameter("txtNombres");
                    String dni1 = request.getParameter("txtDni");
                    int idm1 = Integer.parseInt(request.getParameter("codigomateria"));
                    String user1 = request.getParameter("txtUser");
                    alu.setNombres(nom1);
                    alu.setDni(dni1);
                    alu.setIdMaterias(idm1);
                    alu.setUser(user1);
                    alu.setId(ida);
                    adao.actualizar(alu);
                    request.getRequestDispatcher("Controlador?menu=Alumno&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    ida = Integer.parseInt(request.getParameter("id"));
                    adao.delete(ida);
                    request.getRequestDispatcher("Controlador?menu=Alumno&accion=Listar").forward(request, response);
                    break;
                case "BuscarMateria":                    
                    List listas = mdao.listar();
                    int id = Integer.parseInt(request.getParameter("codigomateria"));
                    ma = mdao.listarId(id);
                    alu = adao.listarId(id);
                    request.setAttribute("alu", alu);
                    request.setAttribute("materias", ma);
                    request.setAttribute("listas", listas);
                    break;     
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Alumno.jsp").forward(request, response);
            }
        if (menu.equals("Profesor")) {
            switch (accion) {
                case "Listar":
                    List lista = pdao.listar();
                    request.setAttribute("profesores", lista);
                    break;
                case "Agregar":
                    String nom = request.getParameter("txtNombres");
                    String dni = request.getParameter("txtDni");
                    String est = request.getParameter("txtEstado");
                    String user = request.getParameter("txtUser");
                    pr.setNombres(nom);
                    pr.setDni(dni);
                    pr.setEstado(est);
                    pr.setUser(user);
                    pdao.agregar(pr);
                    request.getRequestDispatcher("Controlador?menu=Profesor&accion=Listar").forward(request, response);
                    break; 
                case "Editar":
                    idp = Integer.parseInt(request.getParameter("id"));
                    Profesor pro = pdao.listarId(idp);
                    request.setAttribute("profesor", pro);
                    request.getRequestDispatcher("Controlador?menu=Profesor&accion=Listar").forward(request, response);
                    break;  
                case "Actualizar":  
                    String nom1 = request.getParameter("txtNombres");
                    String dni1 = request.getParameter("txtDni");
                    String est1 = request.getParameter("txtEstado");
                    String user1 = request.getParameter("txtUser");
                    pr.setNombres(nom1);
                    pr.setDni(dni1);
                    pr.setEstado(est1);
                    pr.setUser(user1);
                    pr.setId(idp);
                    pdao.actualizar(pr);
                    request.getRequestDispatcher("Controlador?menu=Profesor&accion=Listar").forward(request, response);    
                    break; 
                case "Delete":
                    idp = Integer.parseInt(request.getParameter("id"));
                    pdao.delete(idp);
                    request.getRequestDispatcher("Controlador?menu=Profesor&accion=Listar").forward(request, response);
                    break;        
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Profesor.jsp").forward(request, response);
            }
        if (menu.equals("Materias")) {
            switch (accion) {
                case "Listar":
                    List lista = mdao.listar();
                    request.setAttribute("materia", lista);
                    break;
                case "Agregar":
                    String nom = request.getParameter("txtNombre");
                    String tur = request.getParameter("txtTurno");
                    String dia = request.getParameter("txtDia");
                    int cup = Integer.parseInt(request.getParameter("txtCupoMaxAlumnos"));
                    ma.setNombre(nom);
                    ma.setTurno(tur);
                    ma.setDia(dia);
                    ma.setCupoMaxAlumnos(cup);
                    mdao.agregar(ma);
                    request.getRequestDispatcher("Controlador?menu=Materias&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    idm = Integer.parseInt(request.getParameter("id"));
                    Materias mat = mdao.listarId(idm);
                    request.setAttribute("materias", mat);
                    request.getRequestDispatcher("Controlador?menu=Materias&accion=Listar").forward(request, response);
                    break; 
                case "Actualizar":  
                    String nom1 = request.getParameter("txtNombres");
                    String tur1 = request.getParameter("txtTurno");
                    String dia1 = request.getParameter("txtDia");
                    int cup1 = Integer.parseInt(request.getParameter("txtCupoMaxAlumnos"));
                    ma.setNombre(nom1);
                    ma.setTurno(tur1);
                    ma.setDia(dia1);
                    ma.setCupoMaxAlumnos(cup1);
                    ma.setId(idm);
                    mdao.actualizar(ma);
                    request.getRequestDispatcher("Controlador?menu=Materias&accion=Listar").forward(request, response);    
                    break; 
                case "Delete":
                    idm = Integer.parseInt(request.getParameter("id"));
                    mdao.delete(idm);
                    request.getRequestDispatcher("Controlador?menu=Profesor&accion=Listar").forward(request, response);
                    break;        
                default:    
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Materias.jsp").forward(request, response);    
        }
        if (menu.equals("Inscripcion")) {
            switch (accion) {
                case "BuscarAlumno":
                    String dni=request.getParameter("codigoalumno");
                    alu.setDni(dni);
                    alu=adao.buscar(dni);
                    request.setAttribute("alu", alu);
                    break;
                case "BuscarMateria":
                    int id = Integer.parseInt(request.getParameter("codigomateria"));
                    ma = mdao.listarId(id);
                    request.setAttribute("alu", alu);
                    request.setAttribute("materias", ma);
                    request.setAttribute("lista", lista);
                    break; 
                case "Agregar":
                    request.setAttribute("alu", alu);
                    item = item +1;
                    cod = ma.getId();
                    descripcion = request.getParameter("nommateria");
                    cant = Integer.parseInt(request.getParameter("cant"));
                    insc = new Inscripcion();
                    insc.setItem(item);
                    insc.setIdMaterias(cod);
                    insc.setDescripcionMat(descripcion);
                    insc.setCantidad(cant);
                    lista.add(insc);
                    request.setAttribute("lista", lista);
                    break;
                case "GenerarInscripcion":
                    for (int i = 0; i < lista.size(); i++) {
                        Materias ma = new Materias();
                        int cantidad = lista.get(i).getCantidad();
                        int idMaterias = lista.get(i).getIdMaterias();
                        ma = mdao.buscar(idMaterias);
                        int sac = ma.getCupoMaxAlumnos()-cantidad;
                        mdao.actualizarCantidad(idMaterias, sac);
                    }
                    
                    insc.setIdAlumno(alu.getId());
                    insc.setIdMaterias(ma.getId());
                    insc.setNumeroSerie(numeroserie);
                    insc.setFecha("2021-05-02");
                    insc.setEstado("1");
                    idao.guardarInscripcion(insc);
                    int idins=Integer.parseInt(idao.IdInscripcion());
                    for (int i = 0; i < lista.size(); i++) {
                        insc = new Inscripcion();
                        insc.setIdInscripcion(idins);
                        insc.setIdMaterias(lista.get(i).getIdMaterias());
                        insc.setCantidad(lista.get(i).getCantidad());
                        idao.guardarDetalleInscripcion(insc);
                    }
                    break;                    
                default:
                     numeroserie = idao.GenerarSerie();
                    if (numeroserie==null) {
                        numeroserie="00000001";
                        request.setAttribute("nserie", numeroserie);
                    }
                    else{
                        int incrementar = Integer.parseInt(numeroserie);
                        GenerarSerie gs = new GenerarSerie();
                        numeroserie = gs.NumeroSerie(incrementar);
                        request.setAttribute("nserie", numeroserie);
                        
                    }
                    request.getRequestDispatcher("Inscripcion.jsp").forward(request, response);
            }
            request.getRequestDispatcher("Inscripcion.jsp").forward(request, response);
        }
        }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

        
        }