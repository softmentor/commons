package com.softmentor.common.validator.constraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.softmentor.common.util.jackson.Size;
import com.softmentor.common.util.jackson.SizeUnit;


/**
 * Check that a {@link Size} being validated is greater than or equal to the minimum value specified.
 */
public class MinSizeValidator implements ConstraintValidator<MinSize, Size>
{

    private long     minQty;
    private SizeUnit minUnit;

    @Override
    public void initialize(MinSize constraintAnnotation)
    {
        this.minQty = constraintAnnotation.value();
        this.minUnit = constraintAnnotation.unit();
    }

    @Override
    public boolean isValid(Size value, ConstraintValidatorContext context)
    {
        return (value == null) || (value.toBytes() >= minUnit.toBytes(minQty));
    }
}
