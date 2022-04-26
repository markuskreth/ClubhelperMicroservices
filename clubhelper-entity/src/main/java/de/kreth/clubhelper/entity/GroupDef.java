package de.kreth.clubhelper.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;



/**
 * The persistent class for the groupDef database table.
 */
@Entity
@Table(name = "groupdef")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class GroupDef extends BaseEntity implements Serializable
{
   private static final long serialVersionUID = 1L;
   
   private String name;

   public String getName()
   {
      return name;
   }

   public void setName(String name)
   {
      this.name = name;
   }

   @Override
   public int hashCode()
   {
      final int prime = 53;
      return prime * super.hashCode();
   }

   @Override
   public boolean equals(Object obj)
   {
      if (this == obj) {
         return true;
      }
      return super.equals(obj);
   }

   @Override
   public String toString()
   {
      return "GroupDef [id=" + getId() + ", name=" + name + "]";
   }
}
