package com.studio.work.dubbo.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class WorkStudioExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WorkStudioExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andWorkNameIsNull() {
            addCriterion("work_name is null");
            return (Criteria) this;
        }

        public Criteria andWorkNameIsNotNull() {
            addCriterion("work_name is not null");
            return (Criteria) this;
        }

        public Criteria andWorkNameEqualTo(String value) {
            addCriterion("work_name =", value, "workName");
            return (Criteria) this;
        }

        public Criteria andWorkNameNotEqualTo(String value) {
            addCriterion("work_name <>", value, "workName");
            return (Criteria) this;
        }

        public Criteria andWorkNameGreaterThan(String value) {
            addCriterion("work_name >", value, "workName");
            return (Criteria) this;
        }

        public Criteria andWorkNameGreaterThanOrEqualTo(String value) {
            addCriterion("work_name >=", value, "workName");
            return (Criteria) this;
        }

        public Criteria andWorkNameLessThan(String value) {
            addCriterion("work_name <", value, "workName");
            return (Criteria) this;
        }

        public Criteria andWorkNameLessThanOrEqualTo(String value) {
            addCriterion("work_name <=", value, "workName");
            return (Criteria) this;
        }

        public Criteria andWorkNameLike(String value) {
            addCriterion("work_name like", value, "workName");
            return (Criteria) this;
        }

        public Criteria andWorkNameNotLike(String value) {
            addCriterion("work_name not like", value, "workName");
            return (Criteria) this;
        }

        public Criteria andWorkNameIn(List<String> values) {
            addCriterion("work_name in", values, "workName");
            return (Criteria) this;
        }

        public Criteria andWorkNameNotIn(List<String> values) {
            addCriterion("work_name not in", values, "workName");
            return (Criteria) this;
        }

        public Criteria andWorkNameBetween(String value1, String value2) {
            addCriterion("work_name between", value1, value2, "workName");
            return (Criteria) this;
        }

        public Criteria andWorkNameNotBetween(String value1, String value2) {
            addCriterion("work_name not between", value1, value2, "workName");
            return (Criteria) this;
        }

        public Criteria andDescbIsNull() {
            addCriterion("descb is null");
            return (Criteria) this;
        }

        public Criteria andDescbIsNotNull() {
            addCriterion("descb is not null");
            return (Criteria) this;
        }

        public Criteria andDescbEqualTo(String value) {
            addCriterion("descb =", value, "descb");
            return (Criteria) this;
        }

        public Criteria andDescbNotEqualTo(String value) {
            addCriterion("descb <>", value, "descb");
            return (Criteria) this;
        }

        public Criteria andDescbGreaterThan(String value) {
            addCriterion("descb >", value, "descb");
            return (Criteria) this;
        }

        public Criteria andDescbGreaterThanOrEqualTo(String value) {
            addCriterion("descb >=", value, "descb");
            return (Criteria) this;
        }

        public Criteria andDescbLessThan(String value) {
            addCriterion("descb <", value, "descb");
            return (Criteria) this;
        }

        public Criteria andDescbLessThanOrEqualTo(String value) {
            addCriterion("descb <=", value, "descb");
            return (Criteria) this;
        }

        public Criteria andDescbLike(String value) {
            addCriterion("descb like", value, "descb");
            return (Criteria) this;
        }

        public Criteria andDescbNotLike(String value) {
            addCriterion("descb not like", value, "descb");
            return (Criteria) this;
        }

        public Criteria andDescbIn(List<String> values) {
            addCriterion("descb in", values, "descb");
            return (Criteria) this;
        }

        public Criteria andDescbNotIn(List<String> values) {
            addCriterion("descb not in", values, "descb");
            return (Criteria) this;
        }

        public Criteria andDescbBetween(String value1, String value2) {
            addCriterion("descb between", value1, value2, "descb");
            return (Criteria) this;
        }

        public Criteria andDescbNotBetween(String value1, String value2) {
            addCriterion("descb not between", value1, value2, "descb");
            return (Criteria) this;
        }

        public Criteria andStartIsNull() {
            addCriterion("start is null");
            return (Criteria) this;
        }

        public Criteria andStartIsNotNull() {
            addCriterion("start is not null");
            return (Criteria) this;
        }

        public Criteria andStartEqualTo(Date value) {
            addCriterionForJDBCDate("start =", value, "start");
            return (Criteria) this;
        }

        public Criteria andStartNotEqualTo(Date value) {
            addCriterionForJDBCDate("start <>", value, "start");
            return (Criteria) this;
        }

        public Criteria andStartGreaterThan(Date value) {
            addCriterionForJDBCDate("start >", value, "start");
            return (Criteria) this;
        }

        public Criteria andStartGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("start >=", value, "start");
            return (Criteria) this;
        }

        public Criteria andStartLessThan(Date value) {
            addCriterionForJDBCDate("start <", value, "start");
            return (Criteria) this;
        }

        public Criteria andStartLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("start <=", value, "start");
            return (Criteria) this;
        }

        public Criteria andStartIn(List<Date> values) {
            addCriterionForJDBCDate("start in", values, "start");
            return (Criteria) this;
        }

        public Criteria andStartNotIn(List<Date> values) {
            addCriterionForJDBCDate("start not in", values, "start");
            return (Criteria) this;
        }

        public Criteria andStartBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("start between", value1, value2, "start");
            return (Criteria) this;
        }

        public Criteria andStartNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("start not between", value1, value2, "start");
            return (Criteria) this;
        }

        public Criteria andIpIsNull() {
            addCriterion("ip is null");
            return (Criteria) this;
        }

        public Criteria andIpIsNotNull() {
            addCriterion("ip is not null");
            return (Criteria) this;
        }

        public Criteria andIpEqualTo(String value) {
            addCriterion("ip =", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotEqualTo(String value) {
            addCriterion("ip <>", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThan(String value) {
            addCriterion("ip >", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThanOrEqualTo(String value) {
            addCriterion("ip >=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThan(String value) {
            addCriterion("ip <", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThanOrEqualTo(String value) {
            addCriterion("ip <=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLike(String value) {
            addCriterion("ip like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotLike(String value) {
            addCriterion("ip not like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpIn(List<String> values) {
            addCriterion("ip in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotIn(List<String> values) {
            addCriterion("ip not in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpBetween(String value1, String value2) {
            addCriterion("ip between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotBetween(String value1, String value2) {
            addCriterion("ip not between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andTouxIsNull() {
            addCriterion("toux is null");
            return (Criteria) this;
        }

        public Criteria andTouxIsNotNull() {
            addCriterion("toux is not null");
            return (Criteria) this;
        }

        public Criteria andTouxEqualTo(String value) {
            addCriterion("toux =", value, "toux");
            return (Criteria) this;
        }

        public Criteria andTouxNotEqualTo(String value) {
            addCriterion("toux <>", value, "toux");
            return (Criteria) this;
        }

        public Criteria andTouxGreaterThan(String value) {
            addCriterion("toux >", value, "toux");
            return (Criteria) this;
        }

        public Criteria andTouxGreaterThanOrEqualTo(String value) {
            addCriterion("toux >=", value, "toux");
            return (Criteria) this;
        }

        public Criteria andTouxLessThan(String value) {
            addCriterion("toux <", value, "toux");
            return (Criteria) this;
        }

        public Criteria andTouxLessThanOrEqualTo(String value) {
            addCriterion("toux <=", value, "toux");
            return (Criteria) this;
        }

        public Criteria andTouxLike(String value) {
            addCriterion("toux like", value, "toux");
            return (Criteria) this;
        }

        public Criteria andTouxNotLike(String value) {
            addCriterion("toux not like", value, "toux");
            return (Criteria) this;
        }

        public Criteria andTouxIn(List<String> values) {
            addCriterion("toux in", values, "toux");
            return (Criteria) this;
        }

        public Criteria andTouxNotIn(List<String> values) {
            addCriterion("toux not in", values, "toux");
            return (Criteria) this;
        }

        public Criteria andTouxBetween(String value1, String value2) {
            addCriterion("toux between", value1, value2, "toux");
            return (Criteria) this;
        }

        public Criteria andTouxNotBetween(String value1, String value2) {
            addCriterion("toux not between", value1, value2, "toux");
            return (Criteria) this;
        }

        public Criteria andPidIsNull() {
            addCriterion("pid is null");
            return (Criteria) this;
        }

        public Criteria andPidIsNotNull() {
            addCriterion("pid is not null");
            return (Criteria) this;
        }

        public Criteria andPidEqualTo(Integer value) {
            addCriterion("pid =", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotEqualTo(Integer value) {
            addCriterion("pid <>", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThan(Integer value) {
            addCriterion("pid >", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThanOrEqualTo(Integer value) {
            addCriterion("pid >=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThan(Integer value) {
            addCriterion("pid <", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThanOrEqualTo(Integer value) {
            addCriterion("pid <=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidIn(List<Integer> values) {
            addCriterion("pid in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotIn(List<Integer> values) {
            addCriterion("pid not in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidBetween(Integer value1, Integer value2) {
            addCriterion("pid between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotBetween(Integer value1, Integer value2) {
            addCriterion("pid not between", value1, value2, "pid");
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