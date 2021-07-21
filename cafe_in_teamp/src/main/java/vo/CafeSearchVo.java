package vo;

import java.util.List;

public class CafeSearchVo {
	
	String 	c_loc;
	String 	c_tel;
	int		r_idx;
	int		r_star;
	int		c_parking;
	int		c_alchohol;
	int		c_meal;
	int		c_nokidz;
	
	int	          m_f_idx;
	List<MoodVo>  m_idx_list;
	
	String	m_name;
	
	int             d_f_idx;
	int		        c_idx;
	List<DessertVo>	d_idx_list;
	String	        d_name;
	
	public String getC_loc() {
		return c_loc;
	}
	public void setC_loc(String c_loc) {
		this.c_loc = c_loc;
	}
	public String getC_tel() {
		return c_tel;
	}
	public void setC_tel(String c_tel) {
		this.c_tel = c_tel;
	}
	public int getR_idx() {
		return r_idx;
	}
	public void setR_idx(int r_idx) {
		this.r_idx = r_idx;
	}
	public int getR_star() {
		return r_star;
	}
	public void setR_star(int r_star) {
		this.r_star = r_star;
	}
	public int getC_parking() {
		return c_parking;
	}
	public void setC_parking(int c_parking) {
		this.c_parking = c_parking;
	}
	public int getC_alchohol() {
		return c_alchohol;
	}
	public void setC_alchohol(int c_alchohol) {
		this.c_alchohol = c_alchohol;
	}
	public int getC_meal() {
		return c_meal;
	}
	public void setC_meal(int c_meal) {
		this.c_meal = c_meal;
	}
	public int getC_nokidz() {
		return c_nokidz;
	}
	public void setC_nokidz(int c_nokidz) {
		this.c_nokidz = c_nokidz;
	}
	public int getM_f_idx() {
		return m_f_idx;
	}
	public void setM_f_idx(int m_f_idx) {
		this.m_f_idx = m_f_idx;
	}
	public List<MoodVo> getM_idx_list() {
		return m_idx_list;
	}
	public void setM_idx_list(List<MoodVo> m_idx_list) {
		this.m_idx_list = m_idx_list;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public int getD_f_idx() {
		return d_f_idx;
	}
	public void setD_f_idx(int d_f_idx) {
		this.d_f_idx = d_f_idx;
	}
	public int getC_idx() {
		return c_idx;
	}
	public void setC_idx(int c_idx) {
		this.c_idx = c_idx;
	}
	public List<DessertVo> getD_idx_list() {
		return d_idx_list;
	}
	public void setD_idx_list(List<DessertVo> d_idx_list) {
		this.d_idx_list = d_idx_list;
	}
	public String getD_name() {
		return d_name;
	}
	public void setD_name(String d_name) {
		this.d_name = d_name;
	}
	

	
}
