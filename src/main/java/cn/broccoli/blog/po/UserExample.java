package cn.broccoli.blog.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNikenameIsNull() {
            addCriterion("user_nikename is null");
            return (Criteria) this;
        }

        public Criteria andUserNikenameIsNotNull() {
            addCriterion("user_nikename is not null");
            return (Criteria) this;
        }

        public Criteria andUserNikenameEqualTo(String value) {
            addCriterion("user_nikename =", value, "userNikename");
            return (Criteria) this;
        }

        public Criteria andUserNikenameNotEqualTo(String value) {
            addCriterion("user_nikename <>", value, "userNikename");
            return (Criteria) this;
        }

        public Criteria andUserNikenameGreaterThan(String value) {
            addCriterion("user_nikename >", value, "userNikename");
            return (Criteria) this;
        }

        public Criteria andUserNikenameGreaterThanOrEqualTo(String value) {
            addCriterion("user_nikename >=", value, "userNikename");
            return (Criteria) this;
        }

        public Criteria andUserNikenameLessThan(String value) {
            addCriterion("user_nikename <", value, "userNikename");
            return (Criteria) this;
        }

        public Criteria andUserNikenameLessThanOrEqualTo(String value) {
            addCriterion("user_nikename <=", value, "userNikename");
            return (Criteria) this;
        }

        public Criteria andUserNikenameLike(String value) {
            addCriterion("user_nikename like", value, "userNikename");
            return (Criteria) this;
        }

        public Criteria andUserNikenameNotLike(String value) {
            addCriterion("user_nikename not like", value, "userNikename");
            return (Criteria) this;
        }

        public Criteria andUserNikenameIn(List<String> values) {
            addCriterion("user_nikename in", values, "userNikename");
            return (Criteria) this;
        }

        public Criteria andUserNikenameNotIn(List<String> values) {
            addCriterion("user_nikename not in", values, "userNikename");
            return (Criteria) this;
        }

        public Criteria andUserNikenameBetween(String value1, String value2) {
            addCriterion("user_nikename between", value1, value2, "userNikename");
            return (Criteria) this;
        }

        public Criteria andUserNikenameNotBetween(String value1, String value2) {
            addCriterion("user_nikename not between", value1, value2, "userNikename");
            return (Criteria) this;
        }

        public Criteria andUserPwdIsNull() {
            addCriterion("user_pwd is null");
            return (Criteria) this;
        }

        public Criteria andUserPwdIsNotNull() {
            addCriterion("user_pwd is not null");
            return (Criteria) this;
        }

        public Criteria andUserPwdEqualTo(String value) {
            addCriterion("user_pwd =", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdNotEqualTo(String value) {
            addCriterion("user_pwd <>", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdGreaterThan(String value) {
            addCriterion("user_pwd >", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdGreaterThanOrEqualTo(String value) {
            addCriterion("user_pwd >=", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdLessThan(String value) {
            addCriterion("user_pwd <", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdLessThanOrEqualTo(String value) {
            addCriterion("user_pwd <=", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdLike(String value) {
            addCriterion("user_pwd like", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdNotLike(String value) {
            addCriterion("user_pwd not like", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdIn(List<String> values) {
            addCriterion("user_pwd in", values, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdNotIn(List<String> values) {
            addCriterion("user_pwd not in", values, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdBetween(String value1, String value2) {
            addCriterion("user_pwd between", value1, value2, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdNotBetween(String value1, String value2) {
            addCriterion("user_pwd not between", value1, value2, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPhoneIsNull() {
            addCriterion("user_phone is null");
            return (Criteria) this;
        }

        public Criteria andUserPhoneIsNotNull() {
            addCriterion("user_phone is not null");
            return (Criteria) this;
        }

        public Criteria andUserPhoneEqualTo(Integer value) {
            addCriterion("user_phone =", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotEqualTo(Integer value) {
            addCriterion("user_phone <>", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneGreaterThan(Integer value) {
            addCriterion("user_phone >", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_phone >=", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneLessThan(Integer value) {
            addCriterion("user_phone <", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneLessThanOrEqualTo(Integer value) {
            addCriterion("user_phone <=", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneIn(List<Integer> values) {
            addCriterion("user_phone in", values, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotIn(List<Integer> values) {
            addCriterion("user_phone not in", values, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneBetween(Integer value1, Integer value2) {
            addCriterion("user_phone between", value1, value2, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotBetween(Integer value1, Integer value2) {
            addCriterion("user_phone not between", value1, value2, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserSexIsNull() {
            addCriterion("user_sex is null");
            return (Criteria) this;
        }

        public Criteria andUserSexIsNotNull() {
            addCriterion("user_sex is not null");
            return (Criteria) this;
        }

        public Criteria andUserSexEqualTo(String value) {
            addCriterion("user_sex =", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexNotEqualTo(String value) {
            addCriterion("user_sex <>", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexGreaterThan(String value) {
            addCriterion("user_sex >", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexGreaterThanOrEqualTo(String value) {
            addCriterion("user_sex >=", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexLessThan(String value) {
            addCriterion("user_sex <", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexLessThanOrEqualTo(String value) {
            addCriterion("user_sex <=", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexLike(String value) {
            addCriterion("user_sex like", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexNotLike(String value) {
            addCriterion("user_sex not like", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexIn(List<String> values) {
            addCriterion("user_sex in", values, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexNotIn(List<String> values) {
            addCriterion("user_sex not in", values, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexBetween(String value1, String value2) {
            addCriterion("user_sex between", value1, value2, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexNotBetween(String value1, String value2) {
            addCriterion("user_sex not between", value1, value2, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserQqIsNull() {
            addCriterion("user_qq is null");
            return (Criteria) this;
        }

        public Criteria andUserQqIsNotNull() {
            addCriterion("user_qq is not null");
            return (Criteria) this;
        }

        public Criteria andUserQqEqualTo(String value) {
            addCriterion("user_qq =", value, "userQq");
            return (Criteria) this;
        }

        public Criteria andUserQqNotEqualTo(String value) {
            addCriterion("user_qq <>", value, "userQq");
            return (Criteria) this;
        }

        public Criteria andUserQqGreaterThan(String value) {
            addCriterion("user_qq >", value, "userQq");
            return (Criteria) this;
        }

        public Criteria andUserQqGreaterThanOrEqualTo(String value) {
            addCriterion("user_qq >=", value, "userQq");
            return (Criteria) this;
        }

        public Criteria andUserQqLessThan(String value) {
            addCriterion("user_qq <", value, "userQq");
            return (Criteria) this;
        }

        public Criteria andUserQqLessThanOrEqualTo(String value) {
            addCriterion("user_qq <=", value, "userQq");
            return (Criteria) this;
        }

        public Criteria andUserQqLike(String value) {
            addCriterion("user_qq like", value, "userQq");
            return (Criteria) this;
        }

        public Criteria andUserQqNotLike(String value) {
            addCriterion("user_qq not like", value, "userQq");
            return (Criteria) this;
        }

        public Criteria andUserQqIn(List<String> values) {
            addCriterion("user_qq in", values, "userQq");
            return (Criteria) this;
        }

        public Criteria andUserQqNotIn(List<String> values) {
            addCriterion("user_qq not in", values, "userQq");
            return (Criteria) this;
        }

        public Criteria andUserQqBetween(String value1, String value2) {
            addCriterion("user_qq between", value1, value2, "userQq");
            return (Criteria) this;
        }

        public Criteria andUserQqNotBetween(String value1, String value2) {
            addCriterion("user_qq not between", value1, value2, "userQq");
            return (Criteria) this;
        }

        public Criteria andUserEmailIsNull() {
            addCriterion("user_email is null");
            return (Criteria) this;
        }

        public Criteria andUserEmailIsNotNull() {
            addCriterion("user_email is not null");
            return (Criteria) this;
        }

        public Criteria andUserEmailEqualTo(String value) {
            addCriterion("user_email =", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotEqualTo(String value) {
            addCriterion("user_email <>", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailGreaterThan(String value) {
            addCriterion("user_email >", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailGreaterThanOrEqualTo(String value) {
            addCriterion("user_email >=", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailLessThan(String value) {
            addCriterion("user_email <", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailLessThanOrEqualTo(String value) {
            addCriterion("user_email <=", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailLike(String value) {
            addCriterion("user_email like", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotLike(String value) {
            addCriterion("user_email not like", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailIn(List<String> values) {
            addCriterion("user_email in", values, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotIn(List<String> values) {
            addCriterion("user_email not in", values, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailBetween(String value1, String value2) {
            addCriterion("user_email between", value1, value2, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotBetween(String value1, String value2) {
            addCriterion("user_email not between", value1, value2, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserAddressIsNull() {
            addCriterion("user_address is null");
            return (Criteria) this;
        }

        public Criteria andUserAddressIsNotNull() {
            addCriterion("user_address is not null");
            return (Criteria) this;
        }

        public Criteria andUserAddressEqualTo(String value) {
            addCriterion("user_address =", value, "userAddress");
            return (Criteria) this;
        }

        public Criteria andUserAddressNotEqualTo(String value) {
            addCriterion("user_address <>", value, "userAddress");
            return (Criteria) this;
        }

        public Criteria andUserAddressGreaterThan(String value) {
            addCriterion("user_address >", value, "userAddress");
            return (Criteria) this;
        }

        public Criteria andUserAddressGreaterThanOrEqualTo(String value) {
            addCriterion("user_address >=", value, "userAddress");
            return (Criteria) this;
        }

        public Criteria andUserAddressLessThan(String value) {
            addCriterion("user_address <", value, "userAddress");
            return (Criteria) this;
        }

        public Criteria andUserAddressLessThanOrEqualTo(String value) {
            addCriterion("user_address <=", value, "userAddress");
            return (Criteria) this;
        }

        public Criteria andUserAddressLike(String value) {
            addCriterion("user_address like", value, "userAddress");
            return (Criteria) this;
        }

        public Criteria andUserAddressNotLike(String value) {
            addCriterion("user_address not like", value, "userAddress");
            return (Criteria) this;
        }

        public Criteria andUserAddressIn(List<String> values) {
            addCriterion("user_address in", values, "userAddress");
            return (Criteria) this;
        }

        public Criteria andUserAddressNotIn(List<String> values) {
            addCriterion("user_address not in", values, "userAddress");
            return (Criteria) this;
        }

        public Criteria andUserAddressBetween(String value1, String value2) {
            addCriterion("user_address between", value1, value2, "userAddress");
            return (Criteria) this;
        }

        public Criteria andUserAddressNotBetween(String value1, String value2) {
            addCriterion("user_address not between", value1, value2, "userAddress");
            return (Criteria) this;
        }

        public Criteria andUserLastLoginIpIsNull() {
            addCriterion("user_last_login_ip is null");
            return (Criteria) this;
        }

        public Criteria andUserLastLoginIpIsNotNull() {
            addCriterion("user_last_login_ip is not null");
            return (Criteria) this;
        }

        public Criteria andUserLastLoginIpEqualTo(String value) {
            addCriterion("user_last_login_ip =", value, "userLastLoginIp");
            return (Criteria) this;
        }

        public Criteria andUserLastLoginIpNotEqualTo(String value) {
            addCriterion("user_last_login_ip <>", value, "userLastLoginIp");
            return (Criteria) this;
        }

        public Criteria andUserLastLoginIpGreaterThan(String value) {
            addCriterion("user_last_login_ip >", value, "userLastLoginIp");
            return (Criteria) this;
        }

        public Criteria andUserLastLoginIpGreaterThanOrEqualTo(String value) {
            addCriterion("user_last_login_ip >=", value, "userLastLoginIp");
            return (Criteria) this;
        }

        public Criteria andUserLastLoginIpLessThan(String value) {
            addCriterion("user_last_login_ip <", value, "userLastLoginIp");
            return (Criteria) this;
        }

        public Criteria andUserLastLoginIpLessThanOrEqualTo(String value) {
            addCriterion("user_last_login_ip <=", value, "userLastLoginIp");
            return (Criteria) this;
        }

        public Criteria andUserLastLoginIpLike(String value) {
            addCriterion("user_last_login_ip like", value, "userLastLoginIp");
            return (Criteria) this;
        }

        public Criteria andUserLastLoginIpNotLike(String value) {
            addCriterion("user_last_login_ip not like", value, "userLastLoginIp");
            return (Criteria) this;
        }

        public Criteria andUserLastLoginIpIn(List<String> values) {
            addCriterion("user_last_login_ip in", values, "userLastLoginIp");
            return (Criteria) this;
        }

        public Criteria andUserLastLoginIpNotIn(List<String> values) {
            addCriterion("user_last_login_ip not in", values, "userLastLoginIp");
            return (Criteria) this;
        }

        public Criteria andUserLastLoginIpBetween(String value1, String value2) {
            addCriterion("user_last_login_ip between", value1, value2, "userLastLoginIp");
            return (Criteria) this;
        }

        public Criteria andUserLastLoginIpNotBetween(String value1, String value2) {
            addCriterion("user_last_login_ip not between", value1, value2, "userLastLoginIp");
            return (Criteria) this;
        }

        public Criteria andUserBirthdayIsNull() {
            addCriterion("user_birthday is null");
            return (Criteria) this;
        }

        public Criteria andUserBirthdayIsNotNull() {
            addCriterion("user_birthday is not null");
            return (Criteria) this;
        }

        public Criteria andUserBirthdayEqualTo(Date value) {
            addCriterion("user_birthday =", value, "userBirthday");
            return (Criteria) this;
        }

        public Criteria andUserBirthdayNotEqualTo(Date value) {
            addCriterion("user_birthday <>", value, "userBirthday");
            return (Criteria) this;
        }

        public Criteria andUserBirthdayGreaterThan(Date value) {
            addCriterion("user_birthday >", value, "userBirthday");
            return (Criteria) this;
        }

        public Criteria andUserBirthdayGreaterThanOrEqualTo(Date value) {
            addCriterion("user_birthday >=", value, "userBirthday");
            return (Criteria) this;
        }

        public Criteria andUserBirthdayLessThan(Date value) {
            addCriterion("user_birthday <", value, "userBirthday");
            return (Criteria) this;
        }

        public Criteria andUserBirthdayLessThanOrEqualTo(Date value) {
            addCriterion("user_birthday <=", value, "userBirthday");
            return (Criteria) this;
        }

        public Criteria andUserBirthdayIn(List<Date> values) {
            addCriterion("user_birthday in", values, "userBirthday");
            return (Criteria) this;
        }

        public Criteria andUserBirthdayNotIn(List<Date> values) {
            addCriterion("user_birthday not in", values, "userBirthday");
            return (Criteria) this;
        }

        public Criteria andUserBirthdayBetween(Date value1, Date value2) {
            addCriterion("user_birthday between", value1, value2, "userBirthday");
            return (Criteria) this;
        }

        public Criteria andUserBirthdayNotBetween(Date value1, Date value2) {
            addCriterion("user_birthday not between", value1, value2, "userBirthday");
            return (Criteria) this;
        }

        public Criteria andUserDescriptionIsNull() {
            addCriterion("user_description is null");
            return (Criteria) this;
        }

        public Criteria andUserDescriptionIsNotNull() {
            addCriterion("user_description is not null");
            return (Criteria) this;
        }

        public Criteria andUserDescriptionEqualTo(String value) {
            addCriterion("user_description =", value, "userDescription");
            return (Criteria) this;
        }

        public Criteria andUserDescriptionNotEqualTo(String value) {
            addCriterion("user_description <>", value, "userDescription");
            return (Criteria) this;
        }

        public Criteria andUserDescriptionGreaterThan(String value) {
            addCriterion("user_description >", value, "userDescription");
            return (Criteria) this;
        }

        public Criteria andUserDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("user_description >=", value, "userDescription");
            return (Criteria) this;
        }

        public Criteria andUserDescriptionLessThan(String value) {
            addCriterion("user_description <", value, "userDescription");
            return (Criteria) this;
        }

        public Criteria andUserDescriptionLessThanOrEqualTo(String value) {
            addCriterion("user_description <=", value, "userDescription");
            return (Criteria) this;
        }

        public Criteria andUserDescriptionLike(String value) {
            addCriterion("user_description like", value, "userDescription");
            return (Criteria) this;
        }

        public Criteria andUserDescriptionNotLike(String value) {
            addCriterion("user_description not like", value, "userDescription");
            return (Criteria) this;
        }

        public Criteria andUserDescriptionIn(List<String> values) {
            addCriterion("user_description in", values, "userDescription");
            return (Criteria) this;
        }

        public Criteria andUserDescriptionNotIn(List<String> values) {
            addCriterion("user_description not in", values, "userDescription");
            return (Criteria) this;
        }

        public Criteria andUserDescriptionBetween(String value1, String value2) {
            addCriterion("user_description between", value1, value2, "userDescription");
            return (Criteria) this;
        }

        public Criteria andUserDescriptionNotBetween(String value1, String value2) {
            addCriterion("user_description not between", value1, value2, "userDescription");
            return (Criteria) this;
        }

        public Criteria andUserImageUrlIsNull() {
            addCriterion("user_image_url is null");
            return (Criteria) this;
        }

        public Criteria andUserImageUrlIsNotNull() {
            addCriterion("user_image_url is not null");
            return (Criteria) this;
        }

        public Criteria andUserImageUrlEqualTo(String value) {
            addCriterion("user_image_url =", value, "userImageUrl");
            return (Criteria) this;
        }

        public Criteria andUserImageUrlNotEqualTo(String value) {
            addCriterion("user_image_url <>", value, "userImageUrl");
            return (Criteria) this;
        }

        public Criteria andUserImageUrlGreaterThan(String value) {
            addCriterion("user_image_url >", value, "userImageUrl");
            return (Criteria) this;
        }

        public Criteria andUserImageUrlGreaterThanOrEqualTo(String value) {
            addCriterion("user_image_url >=", value, "userImageUrl");
            return (Criteria) this;
        }

        public Criteria andUserImageUrlLessThan(String value) {
            addCriterion("user_image_url <", value, "userImageUrl");
            return (Criteria) this;
        }

        public Criteria andUserImageUrlLessThanOrEqualTo(String value) {
            addCriterion("user_image_url <=", value, "userImageUrl");
            return (Criteria) this;
        }

        public Criteria andUserImageUrlLike(String value) {
            addCriterion("user_image_url like", value, "userImageUrl");
            return (Criteria) this;
        }

        public Criteria andUserImageUrlNotLike(String value) {
            addCriterion("user_image_url not like", value, "userImageUrl");
            return (Criteria) this;
        }

        public Criteria andUserImageUrlIn(List<String> values) {
            addCriterion("user_image_url in", values, "userImageUrl");
            return (Criteria) this;
        }

        public Criteria andUserImageUrlNotIn(List<String> values) {
            addCriterion("user_image_url not in", values, "userImageUrl");
            return (Criteria) this;
        }

        public Criteria andUserImageUrlBetween(String value1, String value2) {
            addCriterion("user_image_url between", value1, value2, "userImageUrl");
            return (Criteria) this;
        }

        public Criteria andUserImageUrlNotBetween(String value1, String value2) {
            addCriterion("user_image_url not between", value1, value2, "userImageUrl");
            return (Criteria) this;
        }

        public Criteria andUserRegisterTimeIsNull() {
            addCriterion("user_register_time is null");
            return (Criteria) this;
        }

        public Criteria andUserRegisterTimeIsNotNull() {
            addCriterion("user_register_time is not null");
            return (Criteria) this;
        }

        public Criteria andUserRegisterTimeEqualTo(Date value) {
            addCriterion("user_register_time =", value, "userRegisterTime");
            return (Criteria) this;
        }

        public Criteria andUserRegisterTimeNotEqualTo(Date value) {
            addCriterion("user_register_time <>", value, "userRegisterTime");
            return (Criteria) this;
        }

        public Criteria andUserRegisterTimeGreaterThan(Date value) {
            addCriterion("user_register_time >", value, "userRegisterTime");
            return (Criteria) this;
        }

        public Criteria andUserRegisterTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("user_register_time >=", value, "userRegisterTime");
            return (Criteria) this;
        }

        public Criteria andUserRegisterTimeLessThan(Date value) {
            addCriterion("user_register_time <", value, "userRegisterTime");
            return (Criteria) this;
        }

        public Criteria andUserRegisterTimeLessThanOrEqualTo(Date value) {
            addCriterion("user_register_time <=", value, "userRegisterTime");
            return (Criteria) this;
        }

        public Criteria andUserRegisterTimeIn(List<Date> values) {
            addCriterion("user_register_time in", values, "userRegisterTime");
            return (Criteria) this;
        }

        public Criteria andUserRegisterTimeNotIn(List<Date> values) {
            addCriterion("user_register_time not in", values, "userRegisterTime");
            return (Criteria) this;
        }

        public Criteria andUserRegisterTimeBetween(Date value1, Date value2) {
            addCriterion("user_register_time between", value1, value2, "userRegisterTime");
            return (Criteria) this;
        }

        public Criteria andUserRegisterTimeNotBetween(Date value1, Date value2) {
            addCriterion("user_register_time not between", value1, value2, "userRegisterTime");
            return (Criteria) this;
        }

        public Criteria andUserRegisterIpIsNull() {
            addCriterion("user_register_ip is null");
            return (Criteria) this;
        }

        public Criteria andUserRegisterIpIsNotNull() {
            addCriterion("user_register_ip is not null");
            return (Criteria) this;
        }

        public Criteria andUserRegisterIpEqualTo(String value) {
            addCriterion("user_register_ip =", value, "userRegisterIp");
            return (Criteria) this;
        }

        public Criteria andUserRegisterIpNotEqualTo(String value) {
            addCriterion("user_register_ip <>", value, "userRegisterIp");
            return (Criteria) this;
        }

        public Criteria andUserRegisterIpGreaterThan(String value) {
            addCriterion("user_register_ip >", value, "userRegisterIp");
            return (Criteria) this;
        }

        public Criteria andUserRegisterIpGreaterThanOrEqualTo(String value) {
            addCriterion("user_register_ip >=", value, "userRegisterIp");
            return (Criteria) this;
        }

        public Criteria andUserRegisterIpLessThan(String value) {
            addCriterion("user_register_ip <", value, "userRegisterIp");
            return (Criteria) this;
        }

        public Criteria andUserRegisterIpLessThanOrEqualTo(String value) {
            addCriterion("user_register_ip <=", value, "userRegisterIp");
            return (Criteria) this;
        }

        public Criteria andUserRegisterIpLike(String value) {
            addCriterion("user_register_ip like", value, "userRegisterIp");
            return (Criteria) this;
        }

        public Criteria andUserRegisterIpNotLike(String value) {
            addCriterion("user_register_ip not like", value, "userRegisterIp");
            return (Criteria) this;
        }

        public Criteria andUserRegisterIpIn(List<String> values) {
            addCriterion("user_register_ip in", values, "userRegisterIp");
            return (Criteria) this;
        }

        public Criteria andUserRegisterIpNotIn(List<String> values) {
            addCriterion("user_register_ip not in", values, "userRegisterIp");
            return (Criteria) this;
        }

        public Criteria andUserRegisterIpBetween(String value1, String value2) {
            addCriterion("user_register_ip between", value1, value2, "userRegisterIp");
            return (Criteria) this;
        }

        public Criteria andUserRegisterIpNotBetween(String value1, String value2) {
            addCriterion("user_register_ip not between", value1, value2, "userRegisterIp");
            return (Criteria) this;
        }

        public Criteria andUserLastUpdateTimeIsNull() {
            addCriterion("user_last_update_time is null");
            return (Criteria) this;
        }

        public Criteria andUserLastUpdateTimeIsNotNull() {
            addCriterion("user_last_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUserLastUpdateTimeEqualTo(Date value) {
            addCriterion("user_last_update_time =", value, "userLastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andUserLastUpdateTimeNotEqualTo(Date value) {
            addCriterion("user_last_update_time <>", value, "userLastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andUserLastUpdateTimeGreaterThan(Date value) {
            addCriterion("user_last_update_time >", value, "userLastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andUserLastUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("user_last_update_time >=", value, "userLastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andUserLastUpdateTimeLessThan(Date value) {
            addCriterion("user_last_update_time <", value, "userLastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andUserLastUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("user_last_update_time <=", value, "userLastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andUserLastUpdateTimeIn(List<Date> values) {
            addCriterion("user_last_update_time in", values, "userLastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andUserLastUpdateTimeNotIn(List<Date> values) {
            addCriterion("user_last_update_time not in", values, "userLastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andUserLastUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("user_last_update_time between", value1, value2, "userLastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andUserLastUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("user_last_update_time not between", value1, value2, "userLastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andUserWeiboIsNull() {
            addCriterion("user_weibo is null");
            return (Criteria) this;
        }

        public Criteria andUserWeiboIsNotNull() {
            addCriterion("user_weibo is not null");
            return (Criteria) this;
        }

        public Criteria andUserWeiboEqualTo(String value) {
            addCriterion("user_weibo =", value, "userWeibo");
            return (Criteria) this;
        }

        public Criteria andUserWeiboNotEqualTo(String value) {
            addCriterion("user_weibo <>", value, "userWeibo");
            return (Criteria) this;
        }

        public Criteria andUserWeiboGreaterThan(String value) {
            addCriterion("user_weibo >", value, "userWeibo");
            return (Criteria) this;
        }

        public Criteria andUserWeiboGreaterThanOrEqualTo(String value) {
            addCriterion("user_weibo >=", value, "userWeibo");
            return (Criteria) this;
        }

        public Criteria andUserWeiboLessThan(String value) {
            addCriterion("user_weibo <", value, "userWeibo");
            return (Criteria) this;
        }

        public Criteria andUserWeiboLessThanOrEqualTo(String value) {
            addCriterion("user_weibo <=", value, "userWeibo");
            return (Criteria) this;
        }

        public Criteria andUserWeiboLike(String value) {
            addCriterion("user_weibo like", value, "userWeibo");
            return (Criteria) this;
        }

        public Criteria andUserWeiboNotLike(String value) {
            addCriterion("user_weibo not like", value, "userWeibo");
            return (Criteria) this;
        }

        public Criteria andUserWeiboIn(List<String> values) {
            addCriterion("user_weibo in", values, "userWeibo");
            return (Criteria) this;
        }

        public Criteria andUserWeiboNotIn(List<String> values) {
            addCriterion("user_weibo not in", values, "userWeibo");
            return (Criteria) this;
        }

        public Criteria andUserWeiboBetween(String value1, String value2) {
            addCriterion("user_weibo between", value1, value2, "userWeibo");
            return (Criteria) this;
        }

        public Criteria andUserWeiboNotBetween(String value1, String value2) {
            addCriterion("user_weibo not between", value1, value2, "userWeibo");
            return (Criteria) this;
        }

        public Criteria andUserLockIsNull() {
            addCriterion("user_lock is null");
            return (Criteria) this;
        }

        public Criteria andUserLockIsNotNull() {
            addCriterion("user_lock is not null");
            return (Criteria) this;
        }

        public Criteria andUserLockEqualTo(Byte value) {
            addCriterion("user_lock =", value, "userLock");
            return (Criteria) this;
        }

        public Criteria andUserLockNotEqualTo(Byte value) {
            addCriterion("user_lock <>", value, "userLock");
            return (Criteria) this;
        }

        public Criteria andUserLockGreaterThan(Byte value) {
            addCriterion("user_lock >", value, "userLock");
            return (Criteria) this;
        }

        public Criteria andUserLockGreaterThanOrEqualTo(Byte value) {
            addCriterion("user_lock >=", value, "userLock");
            return (Criteria) this;
        }

        public Criteria andUserLockLessThan(Byte value) {
            addCriterion("user_lock <", value, "userLock");
            return (Criteria) this;
        }

        public Criteria andUserLockLessThanOrEqualTo(Byte value) {
            addCriterion("user_lock <=", value, "userLock");
            return (Criteria) this;
        }

        public Criteria andUserLockIn(List<Byte> values) {
            addCriterion("user_lock in", values, "userLock");
            return (Criteria) this;
        }

        public Criteria andUserLockNotIn(List<Byte> values) {
            addCriterion("user_lock not in", values, "userLock");
            return (Criteria) this;
        }

        public Criteria andUserLockBetween(Byte value1, Byte value2) {
            addCriterion("user_lock between", value1, value2, "userLock");
            return (Criteria) this;
        }

        public Criteria andUserLockNotBetween(Byte value1, Byte value2) {
            addCriterion("user_lock not between", value1, value2, "userLock");
            return (Criteria) this;
        }

        public Criteria andUserFreezeIsNull() {
            addCriterion("user_freeze is null");
            return (Criteria) this;
        }

        public Criteria andUserFreezeIsNotNull() {
            addCriterion("user_freeze is not null");
            return (Criteria) this;
        }

        public Criteria andUserFreezeEqualTo(Byte value) {
            addCriterion("user_freeze =", value, "userFreeze");
            return (Criteria) this;
        }

        public Criteria andUserFreezeNotEqualTo(Byte value) {
            addCriterion("user_freeze <>", value, "userFreeze");
            return (Criteria) this;
        }

        public Criteria andUserFreezeGreaterThan(Byte value) {
            addCriterion("user_freeze >", value, "userFreeze");
            return (Criteria) this;
        }

        public Criteria andUserFreezeGreaterThanOrEqualTo(Byte value) {
            addCriterion("user_freeze >=", value, "userFreeze");
            return (Criteria) this;
        }

        public Criteria andUserFreezeLessThan(Byte value) {
            addCriterion("user_freeze <", value, "userFreeze");
            return (Criteria) this;
        }

        public Criteria andUserFreezeLessThanOrEqualTo(Byte value) {
            addCriterion("user_freeze <=", value, "userFreeze");
            return (Criteria) this;
        }

        public Criteria andUserFreezeIn(List<Byte> values) {
            addCriterion("user_freeze in", values, "userFreeze");
            return (Criteria) this;
        }

        public Criteria andUserFreezeNotIn(List<Byte> values) {
            addCriterion("user_freeze not in", values, "userFreeze");
            return (Criteria) this;
        }

        public Criteria andUserFreezeBetween(Byte value1, Byte value2) {
            addCriterion("user_freeze between", value1, value2, "userFreeze");
            return (Criteria) this;
        }

        public Criteria andUserFreezeNotBetween(Byte value1, Byte value2) {
            addCriterion("user_freeze not between", value1, value2, "userFreeze");
            return (Criteria) this;
        }

        public Criteria andUserPowerIsNull() {
            addCriterion("user_power is null");
            return (Criteria) this;
        }

        public Criteria andUserPowerIsNotNull() {
            addCriterion("user_power is not null");
            return (Criteria) this;
        }

        public Criteria andUserPowerEqualTo(Integer value) {
            addCriterion("user_power =", value, "userPower");
            return (Criteria) this;
        }

        public Criteria andUserPowerNotEqualTo(Integer value) {
            addCriterion("user_power <>", value, "userPower");
            return (Criteria) this;
        }

        public Criteria andUserPowerGreaterThan(Integer value) {
            addCriterion("user_power >", value, "userPower");
            return (Criteria) this;
        }

        public Criteria andUserPowerGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_power >=", value, "userPower");
            return (Criteria) this;
        }

        public Criteria andUserPowerLessThan(Integer value) {
            addCriterion("user_power <", value, "userPower");
            return (Criteria) this;
        }

        public Criteria andUserPowerLessThanOrEqualTo(Integer value) {
            addCriterion("user_power <=", value, "userPower");
            return (Criteria) this;
        }

        public Criteria andUserPowerIn(List<Integer> values) {
            addCriterion("user_power in", values, "userPower");
            return (Criteria) this;
        }

        public Criteria andUserPowerNotIn(List<Integer> values) {
            addCriterion("user_power not in", values, "userPower");
            return (Criteria) this;
        }

        public Criteria andUserPowerBetween(Integer value1, Integer value2) {
            addCriterion("user_power between", value1, value2, "userPower");
            return (Criteria) this;
        }

        public Criteria andUserPowerNotBetween(Integer value1, Integer value2) {
            addCriterion("user_power not between", value1, value2, "userPower");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}