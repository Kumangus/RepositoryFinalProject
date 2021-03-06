package _04_message.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import _01_users.model.UsersBean;
import _04_message.model.MessageVO;

public class MessageJDBCDAO {
	private static final String URL = "jdbc:sqlserver://localhost:1433;database=HappyHouse";
	private static final String USERNAME = "sa";
	private static final String PASSWORD = "passw0rd";

	private static final String SELECT_BY_ID = "select * from message where message_id=?";
	private static final String SELECT_ALL = "select * from message";
	private static final String UPDATE = "update message set User_account=?, Message_title=?, Message_describe=?, Message_date=getdate(),Message_type=? where Message_id=?";
	private static final String ADDARTICLE = "insert into message (user_account,message_title,message_describe,message_type,message_date,message_actiontype) values (?,?,?,'A',getdate(),'add')";
	private static final String RESPARTICLE ="insert into message (user_account,message_title,message_describe,message_type,message_date,message_actiontype) values (?,?,?,'A',getdate(),'res')";
	private static final String DELETE = "delete from message where message_id=?";
	private static final String SELECT_BY_ACCOUNT = "select * from users where user_account=?";
	public MessageVO select(int message_id) {
		MessageVO result = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			stmt = conn.prepareStatement(SELECT_BY_ID);
			stmt.setInt(1, message_id);
			rset = stmt.executeQuery();
			if (rset.next()) {
				result = new MessageVO();
				result.setUser_account(rset.getString("user_account"));
				result.setMessage_title(rset.getString("message_title"));
				result.setMessage_describe(rset.getString("message_describe"));
				result.setMessage_date(rset.getDate("message_date"));
				result.setMessage_type(rset.getString("message_type"));
				result.setMessage_id(rset.getInt("message_id"));
				result.setMessage_actiontype(rset.getString("message_actiontype"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rset != null) {
				try {
					rset.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	public List<MessageVO> getAll() {
		List<MessageVO> result = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			stmt = conn.prepareStatement(SELECT_ALL);
			rset = stmt.executeQuery();
			result = new ArrayList<MessageVO>();
			while (rset.next()) {
				MessageVO vo = new MessageVO();
				vo.setUser_account(rset.getString("user_account"));
				vo.setMessage_title(rset.getString("message_title"));
				vo.setMessage_describe(rset.getString("message_describe"));
				vo.setMessage_date(rset.getDate("message_date"));
				vo.setMessage_type(rset.getString("message_type"));
				vo.setMessage_id(rset.getInt("message_id"));
				vo.setMessage_actiontype(rset.getString("message_actiontype"));
				
				result.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rset != null) {
				try {
					rset.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	public MessageVO update(String account, String title, String describe,
			String type, int id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		MessageVO result = null;
		ResultSet rset = null;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			stmt = conn.prepareStatement(UPDATE);
			stmt.setString(1, account);
			stmt.setString(2, title);
			stmt.setString(3, describe);

			stmt.setString(4, type);
			stmt.setInt(5, id);
			int i = stmt.executeUpdate();
			if (i == 1) {
				result = this.select(id);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rset != null) {
				try {
					rset.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	

	public MessageVO addArticle(MessageVO vo) {
		Connection conn = null;
		PreparedStatement stmt = null;
		MessageVO result = null;
		ResultSet rset = null;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			stmt = conn.prepareStatement(ADDARTICLE);
			if (vo != null) {
				stmt.setString(1, vo.getUser_account());
				stmt.setString(2, vo.getMessage_title());
				stmt.setString(3, vo.getMessage_describe());
				int i = stmt.executeUpdate();
				if (i == 1) {
					result = vo;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rset != null) {
				try {
					rset.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	public MessageVO respArticle(MessageVO vo) {
		Connection conn = null;
		PreparedStatement stmt = null;
		MessageVO result = null;
		ResultSet rset = null;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			stmt = conn.prepareStatement(RESPARTICLE);
			if (vo != null) {
				stmt.setString(1, vo.getUser_account());
				stmt.setString(2, vo.getMessage_title());
				stmt.setString(3, vo.getMessage_describe());
				int i = stmt.executeUpdate();
				if (i == 1) {
					result = vo;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rset != null) {
				try {
					rset.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	public boolean delete(int message_id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			stmt = conn.prepareStatement(DELETE);
			stmt.setInt(1, message_id);
			int i = stmt.executeUpdate();
			if (i == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}

	public UsersBean select_account(String user_account) {
		UsersBean result = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			//conn = dataSource.getConnection();
			stmt = conn.prepareStatement(SELECT_BY_ACCOUNT);
			stmt.setString(1, user_account);
			rset = stmt.executeQuery();
			if (rset.next()) {
				result = new UsersBean();
				result.setUser_account(rset.getString("user_account"));
				result.setUser_password(rset.getString("user_password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rset != null) {
				try {
					rset.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	public static void main(String[] args) {

		MessageJDBCDAO dao = new MessageJDBCDAO();
		//查詢
//		 MessageVO vo = dao.select(205);
//		 System.out.println("Message_id : "+vo.getMessage_id());
//		 System.out.println("User_account : "+vo.getUser_account());
//		 System.out.println("Message_title : "+vo.getMessage_title());
//		 System.out.println("Message_describe : "+vo.getMessage_describe());
//		 System.out.println("Message_date : "+vo.getMessage_date());
//		 System.out.println("Message_type : "+vo.getMessage_type());
//		 System.out.println("Message_actiontype : "+vo.getMessage_actiontype());
		//查全部
//		 List<MessageVO> vo = dao.getAll();
//		 for (MessageVO aMesg : vo) {
//		 System.out.println("Message_id : " + aMesg.getMessage_id());
//		 System.out.println("User_account : " + aMesg.getUser_account());
//		 System.out.println("Message_title : " + aMesg.getMessage_title());
//		 System.out.println("Message_describe : "+aMesg.getMessage_describe());
//		 System.out.println("Message_date : " + aMesg.getMessage_date());
//		 System.out.println("Message_type : " + aMesg.getMessage_type());
//		 System.out.println("Message_actiontype : " + aMesg.getMessage_actiontype());
//		 System.out.println();
//		 }
		
		
		//回覆文章
//		MessageVO vo = new MessageVO();
//		vo.setUser_account("Boy991");
//		vo.setMessage_title("賣房子的問題現在4+5的公寓好賣嗎?");
//		vo.setMessage_describe("既然七年可以翻一番.....那為何不再夢下企........==");
//		dao.respArticle(vo);
		
		//更新
//		dao.update("Alex123", "更新成功","123","A",200);
//		System.out.println("更新成功");
		
		//新增

//		MessageVO vo = new MessageVO();
//		vo.setUser_account("Make7775");
//		vo.setMessage_title("賣房子的問題現在4+5的公寓好賣嗎?");
//		vo.setMessage_describe("3");
//		dao.addArticle(vo);
		
//		System.out.println("新增成功");
		
//		//刪除
//		dao.delete(209);
//		System.out.println("刪除成功");
		
		UsersBean vo=dao.select_account("Alex123");
		System.out.println("User_password : "+vo.getUser_password());
		System.out.println("User_account : "+vo.getUser_account());
	}
}