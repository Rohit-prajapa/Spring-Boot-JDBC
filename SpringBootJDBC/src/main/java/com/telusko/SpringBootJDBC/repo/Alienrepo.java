package com.telusko.SpringBootJDBC.repo;

import com.telusko.SpringBootJDBC.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class Alienrepo {

    private JdbcTemplate template;

    public JdbcTemplate getTemplate() {
        return template;
    }

    @Autowired
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    // Insert Alien
    public void save(Alien a) {
        String sql = "INSERT INTO alien(id,name,tech) VALUES(?,?,?)";

        int row = template.update(
                sql,
                a.getId(),
                a.getName(),
                a.getTech()
        );

        System.out.println(row + " row affected");
    }

    // Get All Aliens
    public List<Alien> getAlien() {

        String sql = "SELECT * FROM alien";

        RowMapper<Alien> mapper = new RowMapper<Alien>() {

            @Override
            public Alien mapRow(ResultSet rs, int rowNum)
                    throws SQLException {

                Alien a = new Alien();

                a.setId(rs.getInt("id"));
                a.setName(rs.getString("name"));
                a.setTech(rs.getString("tech"));

                return a;
            }
        };

        List<Alien> aliens = template.query(sql, mapper);

        return aliens;
    }
}