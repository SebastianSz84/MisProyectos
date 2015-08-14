package controlador;

import java.util.Vector;

import negocio.Alumno;
import negocio.Curso;
import negocio.Direccion;
import negocio.Materia;
import negocio.Profesor;
import VO.AlumnoVO;
import VO.CursoVO;
import VO.DireccionVO;
import VO.MateriaVO;
import VO.ProfesorVO;

public class Sistema
{
	private static Sistema instancia;
	private Vector<Alumno> alumnos;
	private Vector<Materia> materias;
	private Vector<Profesor> profesores;
	private Vector<Direccion> direcciones;
	private Vector<Curso> cursos;
	
	public void agregarAlumno(AlumnoVO alumno)
	{
		Alumno a = new Alumno();
		a.setEstado(alumno.getEstado());
		a.setLegajo(alumno.getLegajo());
		a.setNombre(alumno.getNombre());
		alumnos.add(a);
	}
	
	public void agregarMateria(MateriaVO materia)
	{
		Materia m = new Materia();
		m.setNombre(materia.getNombre());
		m.setNumero(materia.getNumero());
		materias.add(m);
	}
	
	public void agregarProfesor(ProfesorVO profesor)
	{
		Profesor p = new Profesor();
		Direccion d = buscarDireccionPorVO(profesor.getDireccion());
		if (d == null)
		{
			d = agregarDireccion(profesor.getDireccion());
		}
		p.setDireccion(d);
		profesores.add(p);
	}
	
	private Direccion agregarDireccion(DireccionVO direccion)
	{
		Direccion d = new Direccion();
		d.setCalle(direccion.getCalle());
		d.setCp(direccion.getCp());
		d.setDepto(direccion.getDepto());
		d.setLocalidad(direccion.getLocalidad());
		d.setNumero(direccion.getNumero());
		d.setPiso(direccion.getPiso());
		direcciones.add(d);
		return d;
	}
	
	private Direccion buscarDireccionPorVO(DireccionVO direccion)
	{
		for (Direccion d : direcciones)
		{
			if (d.equals(direccion))
			{
				return d;
			}
		}
		return null;
	}
	
	public void nuevoCurso(MateriaVO materia, ProfesorVO profesor, int cantidadMaxima)
	{
		Curso c = new Curso();
		c.setCantidadMaxima(cantidadMaxima);
		c.setMateria(buscarMateriaPorVO(materia));
		// c.setNumeroCurso(numeroCurso);
		c.setProfesor(buscarProfesorPorVO(profesor));
		cursos.add(c);
	}
	
	private Profesor buscarProfesorPorVO(ProfesorVO profesor)
	{
		for (Profesor p : profesores)
		{
			if (p.equals(profesor))
			{
				return p;
			}
		}
		return null;
	}
	
	private Materia buscarMateriaPorVO(MateriaVO materia)
	{
		for (Materia m : materias)
		{
			if (m.equals(materia))
			{
				return m;
			}
		}
		return null;
	}
	
	public void eliminarAlumno(AlumnoVO alumno)
	{
		Alumno a = buscarAlumnoPorVO(alumno);
		if (a != null)
		{
			alumnos.removeElement(a);
		}
	}
	
	private Alumno buscarAlumnoPorVO(AlumnoVO alumno)
	{
		for (Alumno a : alumnos)
		{
			if (a.equals(alumno))
			{
				return a;
			}
		}
		return null;
	}
	
	public void eliminarMateria(MateriaVO materia)
	{
		Materia m = buscarMateriaPorVO(materia);
		if (m != null)
		{
			materias.removeElement(m);
		}
	}
	
	public void eliminarCurso(CursoVO curso)
	{
		Curso c = buscarCursoPorVO(curso);
		if (c != null)
		{
			cursos.removeElement(c);
		}
	}
	
	private Curso buscarCursoPorVO(CursoVO curso)
	{
		for (Curso c : cursos)
		{
			if (c.equals(curso))
			{
				return c;
			}
		}
		return null;
	}
	
	public void eliminarProfesor(ProfesorVO profesor)
	{
		Profesor p = buscarProfesorPorVO(profesor);
		if (p != null)
		{
			cursos.removeElement(p);
		}
	}
	
	public AlumnoVO obtenerAlumnoPorLegajo(AlumnoVO alumno)
	{
		Alumno a = buscarAlumnoPorVO(alumno);
		if (a != null)
		{
			return a.getVO();
		}
		return null;
	}
	
	public CursoVO obtenerCursoPorNumero(CursoVO curso)
	{
		Curso c = buscarCursoPorVO(curso);
		if (c != null)
		{
			return c.getVO();
		}
		return null;
	}
	
	public MateriaVO obtenerMateriaPorNumero(MateriaVO materia)
	{
		Materia m = buscarMateriaPorVO(materia);
		if (m != null)
		{
			return m.getVO();
		}
		return null;
	}
	
	public ProfesorVO obtenerProfesorPorLegajo(ProfesorVO profesor)
	{
		Profesor p = buscarProfesorPorVO(profesor);
		if (p != null)
		{
			return p.getVO();
		}
		return null;
	}
	
	public Vector<AlumnoVO> obtenerAlumnos()
	{
		Vector<AlumnoVO> aVO = new Vector<>();
		for (Alumno a : alumnos)
		{
			aVO.add(a.getVO());
		}
		return aVO;
	}
	
	public Vector<CursoVO> obtenerCursos()
	{
		Vector<CursoVO> cVO = new Vector<>();
		for (Curso c : cursos)
		{
			cVO.add(c.getVO());
		}
		return cVO;
	}
	
	public Vector<MateriaVO> obtenerMaterias()
	{
		Vector<MateriaVO> mVO = new Vector<>();
		for (Materia m : materias)
		{
			mVO.add(m.getVO());
		}
		return mVO;
	}
	
	public Vector<ProfesorVO> obtenerProfesores()
	{
		Vector<ProfesorVO> pVO = new Vector<>();
		for (Profesor p : profesores)
		{
			pVO.add(p.getVO());
		}
		return pVO;
	}
	
	public void asignarMateriaProfesor(MateriaVO materia, ProfesorVO profesor)
	{
		Profesor p = buscarProfesorPorVO(profesor);
		if (p != null)
		{
			Materia m = buscarMateriaPorVO(materia);
			if (m != null)
			{
				p.asignarMateria(m);
			}
		}
	}
	
	public void asignarAlumnoCurso(CursoVO curso, AlumnoVO alumno)
	{
		Curso c = buscarCursoPorVO(curso);
		if (c != null)
		{
			Alumno a = buscarAlumnoPorVO(alumno);
			if (a != null)
			{
				c.asignarAlumno(a);
			}
		}
	}
	
	public void eliminarAlumnoCurso(CursoVO curso, AlumnoVO alumno)
	{
		Curso c = buscarCursoPorVO(curso);
		if (c != null)
		{
			Alumno a = buscarAlumnoPorVO(alumno);
			if (a != null)
			{
				c.eliminarAlumno(a);
			}
		}
	}
	
	private Sistema()
	{
	}
	
	public static Sistema getInstancia()
	{
		if (instancia == null)
		{
			instancia = new Sistema();
		}
		return instancia;
	}
	
	public static void main(String[] args)
	{
	}
}