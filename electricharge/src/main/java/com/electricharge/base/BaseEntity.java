//package com.electricharge.base;
//
//import com.baomidou.mybatisplus.activerecord.Model;
//import com.baomidou.mybatisplus.annotations.TableField;
//import com.baomidou.mybatisplus.annotations.TableLogic;
//import com.baomidou.mybatisplus.enums.FieldFill;
//
//import java.util.Date;
//
///**
// * Created by linjiayong on 2017/8/24.
// */
//public abstract class BaseEntity<T extends Model> extends Model<BaseEntity> {
//
//    @TableField(value = "create_time",fill = FieldFill.INSERT)
//    private Date createTime;
//
//    @TableField(value = "creator",fill = FieldFill.INSERT)
//    private String creator;
//
//    @TableField(value = "edit_time",fill = FieldFill.INSERT_UPDATE)
//    private Date editTime;
//
//    @TableField(value = "editor",fill = FieldFill.INSERT_UPDATE)
//    private String editor;
//
//    @TableField(value ="is_del",fill = FieldFill.INSERT)
// //  @TableLogic(delval ="t",value = "f")
//   @TableLogic(delval ="true",value = "false")
//    private boolean isDel;
//
//    @Override
//    public String toString() {
//        return "BaseEntity{" +
//                "createTime=" + createTime +
//                ", creator='" + creator + '\'' +
//                ", editTime=" + editTime +
//                ", editor='" + editor + '\'' +
//                ", isDel='" + isDel + '\'' +
//                '}';
//    }
//
//    public Date getCreateTime() {
//        return createTime;
//    }
//
//    public void setCreateTime(Date createTime) {
//        this.createTime = createTime;
//    }
//
//    public String getCreator() {
//        return creator;
//    }
//
//    public void setCreator(String creator) {
//        this.creator = creator;
//    }
//
//    public Date getEditTime() {
//        return editTime;
//    }
//
//    public void setEditTime(Date editTime) {
//        this.editTime = editTime;
//    }
//
//    public String getEditor() {
//        return editor;
//    }
//
//    public void setEditor(String editor) {
//        this.editor = editor;
//    }
//
//    public boolean getIsDel() {
//        return isDel;
//    }
//
//    public void setIsDel(boolean isDel) {
//        this.isDel = isDel;
//    }
//
////    public  UserInfo getCurrentUserName(){
////        return (UserInfo)SecurityUtils.getSubject().getPrincipal();
////    }
//}
