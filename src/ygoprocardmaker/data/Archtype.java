package ygoprocardmaker.data;

import java.util.Objects;
import org.json.JSONObject;

/**
 *
 * @author Simão Reis <dracostriker@hotmail.com>
 */
public class Archtype {

    private final String name;

    private String code;

    private String extension;

    public Archtype(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public Archtype setCode(String code) {
        this.code = code;
        return this;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Archtype other = (Archtype) obj;
        return Objects.equals(this.name, other.name);
    }

    public static JSONObject toJSON(Archtype archtype) {
        return new JSONObject(archtype);
    }

    public static Archtype fromJSON(JSONObject json) {
        return new Archtype(json.getString("name"))
                .setCode(json.getString("code"));
    }

}
