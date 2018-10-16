package perfolation

import java.util.{Calendar, TimeZone}

class JVMCrossDate(override val milliseconds: Long, c: java.util.Calendar) extends CrossDate {
  override def hour24: Int = c.get(Calendar.HOUR_OF_DAY)
  override def minuteOfHour: Int = c.get(Calendar.MINUTE)
  override def secondOfMinute: Int = c.get(Calendar.SECOND)
  override def milliOfSecond: Int = c.get(Calendar.MILLISECOND)
  override def isAM: Boolean = c.get(Calendar.AM_PM) == 0
  override def timeZoneOffsetMillis: Int = -(c.get(Calendar.ZONE_OFFSET) + c.get(Calendar.DST_OFFSET))
  override def year: Int = c.get(Calendar.YEAR)
  override def month: Int = c.get(Calendar.MONTH)
  override def dayOfWeek: Int = c.get(Calendar.DAY_OF_WEEK)
  override def dayOfMonth: Int = c.get(Calendar.DAY_OF_MONTH)
  override def dayOfYear: Int = c.get(Calendar.DAY_OF_YEAR) - 1
  override def timeZone: String = c.getTimeZone.getDisplayName(false, TimeZone.SHORT)
}