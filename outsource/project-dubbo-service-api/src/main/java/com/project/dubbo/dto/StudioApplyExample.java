package com.project.dubbo.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudioApplyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StudioApplyExample() {
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

        public Criteria andStudionameIsNull() {
            addCriterion("studioname is null");
            return (Criteria) this;
        }

        public Criteria andStudionameIsNotNull() {
            addCriterion("studioname is not null");
            return (Criteria) this;
        }

        public Criteria andStudionameEqualTo(String value) {
            addCriterion("studioname =", value, "studioname");
            return (Criteria) this;
        }

        public Criteria andStudionameNotEqualTo(String value) {
            addCriterion("studioname <>", value, "studioname");
            return (Criteria) this;
        }

        public Criteria andStudionameGreaterThan(String value) {
            addCriterion("studioname >", value, "studioname");
            return (Criteria) this;
        }

        public Criteria andStudionameGreaterThanOrEqualTo(String value) {
            addCriterion("studioname >=", value, "studioname");
            return (Criteria) this;
        }

        public Criteria andStudionameLessThan(String value) {
            addCriterion("studioname <", value, "studioname");
            return (Criteria) this;
        }

        public Criteria andStudionameLessThanOrEqualTo(String value) {
            addCriterion("studioname <=", value, "studioname");
            return (Criteria) this;
        }

        public Criteria andStudionameLike(String value) {
            addCriterion("studioname like", value, "studioname");
            return (Criteria) this;
        }

        public Criteria andStudionameNotLike(String value) {
            addCriterion("studioname not like", value, "studioname");
            return (Criteria) this;
        }

        public Criteria andStudionameIn(List<String> values) {
            addCriterion("studioname in", values, "studioname");
            return (Criteria) this;
        }

        public Criteria andStudionameNotIn(List<String> values) {
            addCriterion("studioname not in", values, "studioname");
            return (Criteria) this;
        }

        public Criteria andStudionameBetween(String value1, String value2) {
            addCriterion("studioname between", value1, value2, "studioname");
            return (Criteria) this;
        }

        public Criteria andStudionameNotBetween(String value1, String value2) {
            addCriterion("studioname not between", value1, value2, "studioname");
            return (Criteria) this;
        }

        public Criteria andProjectidIsNull() {
            addCriterion("projectid is null");
            return (Criteria) this;
        }

        public Criteria andProjectidIsNotNull() {
            addCriterion("projectid is not null");
            return (Criteria) this;
        }

        public Criteria andProjectidEqualTo(Integer value) {
            addCriterion("projectid =", value, "projectid");
            return (Criteria) this;
        }

        public Criteria andProjectidNotEqualTo(Integer value) {
            addCriterion("projectid <>", value, "projectid");
            return (Criteria) this;
        }

        public Criteria andProjectidGreaterThan(Integer value) {
            addCriterion("projectid >", value, "projectid");
            return (Criteria) this;
        }

        public Criteria andProjectidGreaterThanOrEqualTo(Integer value) {
            addCriterion("projectid >=", value, "projectid");
            return (Criteria) this;
        }

        public Criteria andProjectidLessThan(Integer value) {
            addCriterion("projectid <", value, "projectid");
            return (Criteria) this;
        }

        public Criteria andProjectidLessThanOrEqualTo(Integer value) {
            addCriterion("projectid <=", value, "projectid");
            return (Criteria) this;
        }

        public Criteria andProjectidIn(List<Integer> values) {
            addCriterion("projectid in", values, "projectid");
            return (Criteria) this;
        }

        public Criteria andProjectidNotIn(List<Integer> values) {
            addCriterion("projectid not in", values, "projectid");
            return (Criteria) this;
        }

        public Criteria andProjectidBetween(Integer value1, Integer value2) {
            addCriterion("projectid between", value1, value2, "projectid");
            return (Criteria) this;
        }

        public Criteria andProjectidNotBetween(Integer value1, Integer value2) {
            addCriterion("projectid not between", value1, value2, "projectid");
            return (Criteria) this;
        }

        public Criteria andStudioidIsNull() {
            addCriterion("studioid is null");
            return (Criteria) this;
        }

        public Criteria andStudioidIsNotNull() {
            addCriterion("studioid is not null");
            return (Criteria) this;
        }

        public Criteria andStudioidEqualTo(Integer value) {
            addCriterion("studioid =", value, "studioid");
            return (Criteria) this;
        }

        public Criteria andStudioidNotEqualTo(Integer value) {
            addCriterion("studioid <>", value, "studioid");
            return (Criteria) this;
        }

        public Criteria andStudioidGreaterThan(Integer value) {
            addCriterion("studioid >", value, "studioid");
            return (Criteria) this;
        }

        public Criteria andStudioidGreaterThanOrEqualTo(Integer value) {
            addCriterion("studioid >=", value, "studioid");
            return (Criteria) this;
        }

        public Criteria andStudioidLessThan(Integer value) {
            addCriterion("studioid <", value, "studioid");
            return (Criteria) this;
        }

        public Criteria andStudioidLessThanOrEqualTo(Integer value) {
            addCriterion("studioid <=", value, "studioid");
            return (Criteria) this;
        }

        public Criteria andStudioidIn(List<Integer> values) {
            addCriterion("studioid in", values, "studioid");
            return (Criteria) this;
        }

        public Criteria andStudioidNotIn(List<Integer> values) {
            addCriterion("studioid not in", values, "studioid");
            return (Criteria) this;
        }

        public Criteria andStudioidBetween(Integer value1, Integer value2) {
            addCriterion("studioid between", value1, value2, "studioid");
            return (Criteria) this;
        }

        public Criteria andStudioidNotBetween(Integer value1, Integer value2) {
            addCriterion("studioid not between", value1, value2, "studioid");
            return (Criteria) this;
        }

        public Criteria andApplytimeIsNull() {
            addCriterion("applytime is null");
            return (Criteria) this;
        }

        public Criteria andApplytimeIsNotNull() {
            addCriterion("applytime is not null");
            return (Criteria) this;
        }

        public Criteria andApplytimeEqualTo(Date value) {
            addCriterion("applytime =", value, "applytime");
            return (Criteria) this;
        }

        public Criteria andApplytimeNotEqualTo(Date value) {
            addCriterion("applytime <>", value, "applytime");
            return (Criteria) this;
        }

        public Criteria andApplytimeGreaterThan(Date value) {
            addCriterion("applytime >", value, "applytime");
            return (Criteria) this;
        }

        public Criteria andApplytimeGreaterThanOrEqualTo(Date value) {
            addCriterion("applytime >=", value, "applytime");
            return (Criteria) this;
        }

        public Criteria andApplytimeLessThan(Date value) {
            addCriterion("applytime <", value, "applytime");
            return (Criteria) this;
        }

        public Criteria andApplytimeLessThanOrEqualTo(Date value) {
            addCriterion("applytime <=", value, "applytime");
            return (Criteria) this;
        }

        public Criteria andApplytimeIn(List<Date> values) {
            addCriterion("applytime in", values, "applytime");
            return (Criteria) this;
        }

        public Criteria andApplytimeNotIn(List<Date> values) {
            addCriterion("applytime not in", values, "applytime");
            return (Criteria) this;
        }

        public Criteria andApplytimeBetween(Date value1, Date value2) {
            addCriterion("applytime between", value1, value2, "applytime");
            return (Criteria) this;
        }

        public Criteria andApplytimeNotBetween(Date value1, Date value2) {
            addCriterion("applytime not between", value1, value2, "applytime");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Integer> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Integer> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andCompleteIsNull() {
            addCriterion("complete is null");
            return (Criteria) this;
        }

        public Criteria andCompleteIsNotNull() {
            addCriterion("complete is not null");
            return (Criteria) this;
        }

        public Criteria andCompleteEqualTo(Double value) {
            addCriterion("complete =", value, "complete");
            return (Criteria) this;
        }

        public Criteria andCompleteNotEqualTo(Double value) {
            addCriterion("complete <>", value, "complete");
            return (Criteria) this;
        }

        public Criteria andCompleteGreaterThan(Double value) {
            addCriterion("complete >", value, "complete");
            return (Criteria) this;
        }

        public Criteria andCompleteGreaterThanOrEqualTo(Double value) {
            addCriterion("complete >=", value, "complete");
            return (Criteria) this;
        }

        public Criteria andCompleteLessThan(Double value) {
            addCriterion("complete <", value, "complete");
            return (Criteria) this;
        }

        public Criteria andCompleteLessThanOrEqualTo(Double value) {
            addCriterion("complete <=", value, "complete");
            return (Criteria) this;
        }

        public Criteria andCompleteIn(List<Double> values) {
            addCriterion("complete in", values, "complete");
            return (Criteria) this;
        }

        public Criteria andCompleteNotIn(List<Double> values) {
            addCriterion("complete not in", values, "complete");
            return (Criteria) this;
        }

        public Criteria andCompleteBetween(Double value1, Double value2) {
            addCriterion("complete between", value1, value2, "complete");
            return (Criteria) this;
        }

        public Criteria andCompleteNotBetween(Double value1, Double value2) {
            addCriterion("complete not between", value1, value2, "complete");
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