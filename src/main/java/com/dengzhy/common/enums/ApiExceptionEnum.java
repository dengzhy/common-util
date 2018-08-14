package com.dengzhy.common.enums;


import com.dengzhy.common.exception.ApiException;
import com.dengzhy.common.exception.BaseExceptionCode;

/**
 * FileName: ApiExceptionEnum
 * Author: dengzhy
 * Description: 异常枚举
 */
public enum ApiExceptionEnum implements BaseExceptionCode {

    /**
     * 01***--09***，系统异常
     * 10***--19***，HTTP异常
     * 20***--59***，SOA异常
     * 60***--99***，系统内部业务异常
     */
    ERROR_CODE("-1","sign错误"),
    NO_PARAM_ERROR("01000", "没有参数"),
    ERROR_PARAM("01001","参数不正确"),
    DEFAULT_ERROR("10500", "服务器繁忙，请稍候重试!"),
    DATA_HUGE_ERROR("10501", "符合搜索条件的银行太多!"),
    DATE_NO_COMPLETE_ERROR("10502", "开始时间或者结束时间未选择"),
    DATE_HUGE_ERROR("10503", "时间间隔最多45天"),
    SOA_ERROR("20000", "SOA异常"),

    /**
     * 用户模块-通用
     */
    USER_ERROR("60000", "用户模块异常"),
    USER_NOT_LOGIN("60001", "用户未登录"),
    USER_NOT_EXIST("60002", "用户不存在或者密码错误"),
    CANNOT_USE_DEFAULT_PASSWORD("60003", "请修改密码"),
    USER_NOT_HAVE_RIGHT("60004", "用户没有权限"),
    USER_NOT_EXITS_ERROR("60102", "用户不存在"),
    USER_OLD_PASSWORD_ERROR("60108", "原密码不正确"),
    CANNOT_SET_DEFAULT_PASSWORD_ERROR("60110", "不能设置为默认密码"),
    USER_PASSWORD_ERROR("60107", "修改新密码不存在"),
    USER_PASSWORD_NOT_SAME_ERROR("60109", "两次输入的密码不一致"),
    PLEASE_INPUT_USER_NAME("60110","请输入用户名"),
    PLEASE_INPUT_USER_PASSWORD("60111","请输入密码"),
    USER_WAS_DISABLED("60112","用户被禁用，请联系管理员"),
    USER_LOGIN_WAS_LOSE("60113","登录信息失效，请重新登录"),
    USER_LOGIN_LOGOUT("60114","用户已注销"),
    USER_TYPE_ERROR("60115","用户类型错误"),
    USER_WAS_LOGIN("60116","用户已经登录"),
    THE_PRINCIPAL_ACCOUNT_OF_THE_INSTITUTION_IS_LOCKED("60117","机构主账户被锁定，不能登录"),
    NO_QUERY_TO_YOUR_MAIN_BODY("60118","没有查询到您所属的主机构，不能登录"),
    SUPPLIER_USERS_DO_NOT_EXIST("60119", "供应商用户不存在"),
    SUPPLIER_CANNOT_TO_LOGIN("60119","供应商不能登录"),
    NOT_MIAN_ACCOUNT("60120","非主账号不能访问"),
    USER_NAME_OR_PASSWORD_ERROR("60121","用户名或密码错误"),
    /**
     * 后台用户模块
     */
    USER_PLATFORM_CODE_ERROR("60201","工号或手机号不能重复"),
    PERMISSION_LEVE_ERROR("60202","权限级别不可超过按钮级别"),
    del_permission_have_children("60203", "存在子权限，不可删除"),
    NO_ROLE("60204","没有给用户分配角色"),
    PLATFORM_USER_MOBILE_ERROR("60205","手机号码异常"),
    del_point_role_have_point_user("60206", "存在使用该角色的用户，不可删除"),
    NO_REGIT("60207","无权限"),
    NO_USER("60208","用户不存在"),
    NO_ROLE_EXIST("60209","角色不存在"),
    LOGIN_TIMEOUT("60210","登录超时"),
    NO_PERMISSION("60211","权限不存在或被移除"),
    USER_WAS_LEAVE("60212","用户已离职"),
    DELIVERY_NUM_CONFIG_ERROR("60213","收货地址数量配置异常"),

    /**
     * 机构配件模块
     * */
    ORGANIZATION_STOCK_NOT_EXIST("60300","该配件不存在"),
    INSERT_OR_UPDATE_NONE_OR_ERROR("60301","上传配件信息为空或错误"),
    LACK_OF_ORGANIZATION_STOCK("60302", "购买量大于库存数量，请重新输入购买数量"),
    ORGANIZATION_STOCK_SALEPRICE_GREATER_ZEAR("60303","配件价格大于0"),

    /**
     * 收货地址
     * */
    DELIVERY_NUM_IS_FULL("60400","收货地址数量已满"),
    ERROR_DELIVERY("60401","收货地址错误"),

    /**
     * 购物车订单模块
     */
    NO_RESULT_FOR_CART("70000","购物车为空，不能下单"),
    CANNOT_BUY_MYSELF_ACCESSORIES("70001","不能购买自已的配件"),
    NULL_OF_CONSIGNEE("70002","收货地址错误，请确认"),
    ERROR_OF_CONSIGNEE("70003","收货人错误，请确认"),
    NULL_OF_CONSIGNEE_NAME("70004","收货人名称不能为空，请确认"),
    NULL_OF_CONSIGNEE_MOBILE("70005","收货人电话不能为空，请确认"),
    NULL_OF_PAY_TYPE("70006","请选择支付方式"),
    ACCESSORIES_ERROR("70007","配件错误，请勿下单"),
    ERROR_CREATE_ORDER_MAIN("70008","创建主订单失败，请稍后操作"),
    ERROR_CREATE_ORDER("70009","创建订单失败，请稍后操作"),
    ERROR_CHOOSE_CANCEL("70010","请选择取消订单原因"),
    ORDER_DOES_NOT_EXIST("70011","订单不存在，不能取消"),
    ORDERS_WAS_CANCELED("70012","订单已取消，不能重复取消"),
    ORDERS_WAS_DELETED("70013","订单已删除，取消错误"),
    ERROR_ORDERS_WAS_CANCEL("70014","订单取消异常，请稍后重试"),
    CHECK_THE_ACCESSORIES("70015","请勾选配件下单"),
    PERFECT_ORDER_INFORMATION("70016","请完善订单信息再下单"),
    ORDER_DOES_NOT_EXIST_CANNOT_RECEIVE("70017","订单不存在，不能确认收货"),
    ORDER_IS_DELETE_CANNOT_RECEIVE("70018","订单已删除，不能确认收货"),
    ORDER_WAS_CANCEL_CANNOT_RECEIVE("70019","订单已取消，不能确认收货"),
    ORDER_WAS_PAST_DUE_CANNOT_RECEIVE("70020","订单已过期，不能确认收货"),
    ORDER_IS_NOT_PAY_CANNOT_RECEIVE("70021","订单未支付，不能确认收货"),
    ORDER_INFO_ERROR("70022","订单信息错误，请稍后操作"),
    ORDER_IS_PAY_AND_NOT_DELIVER_CANNOT_DELETE("70023","订单已支付没有完成，不能删除"),
    ORDER_IS_NOT_SEND_CANNOT_RECEIVE("70024","当前不能收货"),
    ORDER_IS_NOT_USER_CREATE("70025","此订单不是你创建的不能收货"),
    CHOOSE_ORDER_TO_SEND("70026","请选择订单进行发货"),
    ORDER_DOES_NOT_EXIST_TO_SEND("70027","订单不存在不能发货"),
    SENDER_WAS_NOT_EXIST("70028","发货人不存在不能发货"),
    IS_NOT_SENDER("70029","您不是发货人不能发货"),
    ERROR_SENDER("70030","当前订单不能发货，请您查看订单状态或付款状态"),
    WAS_DELETE_CANNOT_TO_SEND("70031","当前订单已删除，不能发货"),
    ERROR_TO_SEND("70032","发货失败"),
    PLEASE_FILL_IN_THE_SHIPPING_COMPANY("70033","请填写承运公司"),
    PLEASE_FILL_IN_THE_CARRIER_NUMBER("70034","请填写承运单号"),
    PLEASE_UPLOAD_THE_PAYMENT_VOUCHER("70035","请上传支付凭证"),
    ORDER_WAS_NOT_EXIT("70036","订单不存在"),
    PART_INFORMATION_ERROR("70037","配件信息错误"),
    ORDER_DATA_ERROR("70038","订单数据错误"),
    CART_NOT_EXIST("70039", "该购物车信息不存在，请重新添加配件"),
    ORDER_WAS_NOT_EXIT_CANOT_TO_PAY("70040", "订单不存在，不能支付"),
    ABNORMAL_ORDER_AMOUNT("70041", "订单金额异常，不能支付"),
    CART_PART_COUNT_ERROR("70042", "购物车配件数量不能少于0"),
    CART_COUNT_ERROR("70043", "购物车数据出错"),
    THE_CONSIGNOR_ORGANIZATION_IS_WRONG("70044", "发货人机构错误，不能发货"),
    REQUEST_WECHAT_TO_GENERATE_THE_QR_CODE_FAILED("70045", "请求微信生成二维码失败"),
    THE_ORDER_HAS_EXPIRED_AND_CANNOT_BE_PAID("70046", "订单已过期，不能支付"),
    THE_ORDER_HAS_BEEN_CANCELLED_AND_CANNOT_BE_PAID("70047", "订单已取消，不能支付"),
    THE_ORDER_HAS_BEEN_DELETE_AND_CANNOT_BE_PAID("70047", "订单已删除，不能支付"),
    THE_ORDER_HAS_BEEN_PAID_AND_CANNOT_BE_PAID("70048", "订单已支付，不能重复支付"),
    /**
     * 询报价模块
     */
    IS_DELETE_FOR_OFFER_ACCESSORIES("80001","报价配件信息已删除，请重新询价"),
    QUOTE_MASTER_ERROR("80002", "主报价单错误，未生成或生成多个，请联系管理员"),
    INQUIRY_PART_AMOUNT_ERROR("80003", "询价零件数量错误，可能为空"),
    QUOTE_SLAVE_REPEAT("80004", "报价单重复，请重新报价"),
    QUOTE_MASTER_STATUS_ERROR("80005", "报价单状态错误，请检查报价单状态"),
    INQUIRY_COUNT_ERROR("80006", "未通过审核机构，询价次数不能超过限制"),
    NO_INQUIRY_ORGANIZATION("80007", "未选择询价机构或系统推荐失败"),
    QUOTE_PRICE_IS_NULL("80008", "配件报价价格为空，请重新报价"),
    SELECT_ALL_ORGANIZATION_IS_NOT_SUPPLIER("80009", "选择的所有机构都不是供应商"),

    /**
     * 品牌模块
     * */
    BRAND_LIMIT_MAX("90001","免配额品牌数已达最大限定数"),
    BRAND_CHECK_STATUS("90002","品牌审核中，无法修改"),
    BRAND_NO_UPDATE("90003","该状态品牌无法修改"),
    BRAND_NO_DELETE("90004","该状态品牌无法删除"),
    UPDATE_ONLY_SUCCESS("90005","只有审核通过的供应商品牌可以修改"),
    ISEXISTS_BRAND("90006","该品牌已经添加过，不能重复添加"),
    NO_DELETE_CHECKING("90007","品牌审核中，无法删除"),
    NO_DELETE_DIRECT("90008","不能删除免配额品牌"),
    ADD_ONLY_SUCCESS("90009","维修厂不能添加品牌"),


    /**
     * 机构模块
     * */
    ORGANANIZATION_TYPE_NOT_EXISTS("91001","机构类型不存在"),
    BRIDGE_LIMIT_MAX("91002","常用供应商数已达最大值"),
    NO_EXISTS_ADDRESS("91003","详细地址不存在"),
    EXISTS_BRIDGE("91004","供应商已存在，添加失败"),

    /**
     * 机构员工模块
     * */
    PHONE_NOT_REGISTER("92001","手机号未注册"),
    PHONE_IN_USE("92002","该手机号已被使用"),
    EXCEPTION_TYPE_EMPLOYEE("92003","机构员工状态异常"),
    NO_OPERATION_SUB("92004","子账号没有操作权限"),
    DISABLE_ACCOUNT("92005","该账号已被禁用"),
    EXCEPTION_MODEL("92006","模块异常"),
    SUB_ONLY("92007","只有管理员能够添加子账号"),



    /**
     * 账户模块
     */
    ACCOUNT_TYPE_ERROR("93001","账户类型不匹配"),
    WITHDRAWAL_AMOUNT_MUST_BE_GREATER_THAN_THE_HANDLING_FEE("93002","提现金额必须大于手续费"),
    PLEASE_COMPLETE_THE_ORDER_CREATION_ACCOUNT_FIRST("93003","您还没有账户，请先完成订单创建账户"),
    NO_BANK_CARD("93004","您还没有添加银行卡"),
    CASH_ACCOUNT_BALANCE_MUST_BE_GREATER_THAN_ZERO("93005","提现账户余额必须大于零后，才可提现"),
    THE_WITHDRAWAL_AMOUNT_SHALL_NOT_EXCEED_THE_ACCOUNT_AMOUNT("93006","提现金额不能大于账户金额"),
    THERE_ARE_WITHDRAWAL_REQUESTS_IN_PROGRESS("93007","有处理中的提现请求，不能再次提现"),
    WITHDRAWAL_RECORDS_DO_NOT_EXIST("93009","提现记录不存在"),
    WITHDRAWAL_RECORDS_ARE_NOT_UNPROCESSED("93010","提现记录不是未处理状态"),
    FINANCEL_IN_OUT_COUNT_ERROR("93011", "一个提现记录对应了多条流水记录"),
    NO_PLATFORM_BALANCE_ACCOUNT("93012", "不存在平台余额账户"),
    NO_FINANCEL_IN_OUT_ERROR("93013", "不存在提现流水记录"),

    /**
     * 系统配置参数模块
     * */
    PARAM_ISEXISTS_SYS("94001","系统配置参数已存在"),
    ERROR_AUTO_RECOMMEND_SYS("94002","系统配置自动推荐供应商参数错误"),
    ERROR_VERSION_NUM_SYS("94003","版本号错误"),

    /**
     * 发票模块
     * */
    EXCEPTION_TYPE_RECEIPT("95001","发票类型异常"),
    ORGANIZATION_INVOICE_NOT_EXISTS("95002","机构发票不存在"),

    /**
     * 车型信息模块
     * */
    PARAM_ISEXISTS_CAR_INFO("96001","车型信息已存在"),

    /**
    * Excel上传模块
    * */
    EXCEL_NO("10600","不是excel文件,请重新上传"),
    IMPORT_ERROR("10601","导入类型出错"),
    SPECIAL_CHAR("10602","含特殊字符"),
    HAS_OEM("10603","已有此oem号的配件"),
    NO_PRODUCT("10604","不含此配件"),
    STOCK_ERROR("10605","库存异常"),
    NO_MUCH_STOCK("10606","没有充足的库存"),
    NO_DELIVERY("10607","收货地址不存在"),
    ABNORMAL_PRICES_OF_SPARE_PARTS_IN_STOCK("10608","库存配件价格异常"),

    /**
    * 短信模块
    * */
    MESSAGE_TO_MANY("10700","1分钟之内不能重发2次"),
    MSG_TYPE_ERROR("10701","短信类型错误"),
    MSG_CODE_ERROR("10702","验证码错误"),
    MOBILE_ERROR("10703","手机号有误"),
    WITHDRAW_MONEY_ERROR("10704","提现前后金额不一致,请重发短信"),

    /**
     * 银行卡模块
     * */
    BANK_CARD_IS_EXIST_ERROR("10800", "该银行卡信息已存在，请勿重复添加"),

    /**
     * 银行卡模块
     * */
    VIN_INFO_ERROR("10900", "车辆信息获取错误，请检查vin码是否正确"),
    ;


    private String code;

    private String message;

    /**
     * @param code
     * @param message
     */
    ApiExceptionEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public ApiException buildException() {
        return new ApiException(this);
    }

    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 根据code获取相应的异常信息
     *
     * @param code
     * @return
     */
    public static ApiExceptionEnum getByCode(String code) {
        for (ApiExceptionEnum apiExecptionEnum : ApiExceptionEnum.values()) {
            if (apiExecptionEnum.getCode().equals(code)) {
                return apiExecptionEnum;
            }
        }
        throw new IllegalArgumentException("invalid token code=" + code);
    }

}
